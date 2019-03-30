package com.olx.services;

import com.olx.model.*;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.model.dto.ValidationStatisticsDTO;
import com.olx.utils.IOUtil;
import com.olx.utils.MobileNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Validation service.
 */
@Service
public class ValidationService {

    @Autowired
    MobileNumberService mobileNumberService;

    @Autowired
    ProcessedFileService processedFileService;


    /**
     * Gets latest.
     *
     * @return the latest file uploaded and it statistics
     */
    public ValidationResultDTO getLatest() {
        ProcessedFile latestProcessedFile = processedFileService.getLatest();
        List<MobileNumber> mobileNumbers = mobileNumberService.findByFileId(latestProcessedFile.getId());
        return transformToDTO(mobileNumbers, latestProcessedFile);
    }

    /**
     * Gets file results.
     *
     * @param id the id
     * @return the file results
     */
    public ValidationResultDTO getFileResults(Long id) {
        ProcessedFile processedFile = processedFileService.findById(id);
        List<MobileNumber> mobileNumbers = mobileNumberService.findByFileId(processedFile.getId());
        return transformToDTO(mobileNumbers, processedFile);
    }

    /**
     * Validate file.
     * This function is for reading the multipart file and validating the numbers
     * and saving the mobile number
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public ValidationResultDTO validateFile(MultipartFile file) throws IOException {

        // Read the file
        List<MobileNumberInput> inputList = IOUtil.readMobileNumbers(file);

        // Map the input to list of validated numbers
        List<MobileNumber> mobileNumbers = inputList.stream().map(MobileNumberValidator::validate).collect(Collectors.toList());

        // Save ProcessedFile record
        ProcessedFile processedFile = processedFileService.save(file.getOriginalFilename());

        // Save the numbers and create the DTO object for REST API
        ValidationResultDTO result = transformToDTO(mobileNumbers, processedFile);
        mobileNumberService.saveAll(result.getNumbersToCreate());
        mobileNumberService.updateAll(result.getNumbersToUpdate());
        return result;
    }

    public MobileNumber validateNumber(String mobileNumber) {
        return MobileNumberValidator.validate(mobileNumber);
    }

    private ValidationResultDTO transformToDTO(List<MobileNumber> mobileNumbers, ProcessedFile processedFile) {

        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        ValidationStatisticsDTO statisticsDTO = new ValidationStatisticsDTO();

        int numberOfValid = 0;
        int numberOfFixed = 0;
        int numberOfInvalid = 0;

        for (MobileNumber mobileNumber : mobileNumbers) {
            if (mobileNumber instanceof ValidNumber) {
                numberOfValid++;
            } else if (mobileNumber instanceof FixedNumber) {
                numberOfFixed++;
            } else {
                numberOfInvalid++;
            }

            MobileNumber savedMobileNumber = mobileNumberService.findById(mobileNumber.getId());
            mobileNumber.setProcessedFile(processedFile);
            if (savedMobileNumber == null) {
                validationResultDTO.getNumbersToCreate().add(mobileNumber);
            } else if (!savedMobileNumber.getClass().equals(mobileNumber.getClass())) {
                validationResultDTO.getNumbersToUpdate().add(mobileNumber);
            }
        }

        statisticsDTO.setValid(numberOfValid);
        statisticsDTO.setFixed(numberOfFixed);
        statisticsDTO.setInvalid(numberOfInvalid);
        statisticsDTO.setCreated(validationResultDTO.getNumbersToCreate().size());
        statisticsDTO.setUpdated(validationResultDTO.getNumbersToUpdate().size());
        validationResultDTO.setMobileNumbers(mobileNumbers);
        validationResultDTO.setStatistics(statisticsDTO);
        validationResultDTO.setProcessedFileId(processedFile.getId());
        return validationResultDTO;
    }
}
