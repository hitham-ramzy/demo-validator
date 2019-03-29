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
     * Validate file.
     * This function is for reading the multipart file and validating the numbers
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
        mobileNumberService.saveAll(mobileNumbers);
        return result;
    }

    public MobileNumber validateNumber(String mobileNumber) {
        return MobileNumberValidator.validate(mobileNumber);
    }

    private ValidationResultDTO transformToDTO(List<MobileNumber> mobileNumbers, ProcessedFile processedFile) {

        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        ValidationStatisticsDTO statisticsDTO = new ValidationStatisticsDTO();
        int numberOfCreated = 0;
        int numberOfUpdated = 0;

        for (MobileNumber mobileNumber : mobileNumbers) {
            if (mobileNumber instanceof ValidNumber) {
                validationResultDTO.getValidNumbers().add(mobileNumber);
            } else if (mobileNumber instanceof FixedNumber) {
                validationResultDTO.getFixedNumbers().add(mobileNumber);
            } else {
                validationResultDTO.getInvalidNumbers().add(mobileNumber);
            }

            MobileNumber savedMobileNumber = mobileNumberService.findById(mobileNumber.getId());
            if (savedMobileNumber == null) {
                numberOfCreated++;
            } else if (!savedMobileNumber.getClass().equals(mobileNumber.getClass())) {
                numberOfUpdated++;
            }
        }

        statisticsDTO.setValid(validationResultDTO.getValidNumbers().size());
        statisticsDTO.setFixed(validationResultDTO.getFixedNumbers().size());
        statisticsDTO.setInvalid(validationResultDTO.getInvalidNumbers().size());
        statisticsDTO.setCreated(numberOfCreated);
        statisticsDTO.setUpdated(numberOfUpdated);
        validationResultDTO.setStatistics(statisticsDTO);
        validationResultDTO.setProcessedFileId(processedFile.getId());
        return validationResultDTO;
    }
}
