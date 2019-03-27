package com.olx.services;

import com.olx.mapper.ValidationResultMapper;
import com.olx.model.*;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.utils.IOUtil;
import com.olx.utils.MobileNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Validation service.
 */
@Service
public class ValidationService {

    @Autowired
    UploadActionService uploadActionService;

    @Autowired
    ValidNumberService validNumberService;

    @Autowired
    FixedNumberService fixedNumberService;

    @Autowired
    InvalidNumberService invalidNumberService;

    /**
     * Validate file.
     * This function is for reading the multipart file and validating the numbers
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public ValidationResultDTO validateFile(MultipartFile file) throws IOException {

        List<ValidNumber> validNumbers = new ArrayList<>();
        List<FixedNumber> fixedNumbers = new ArrayList<>();
        List<InvalidNumber> invalidNumbers = new ArrayList<>();

        // Read the file
        List<MobileNumberInput> inputList = IOUtil.readMobileNumbers(file);
        UploadAction uploadAction = uploadActionService.save(new UploadAction());
        for (MobileNumberInput input : inputList) {
            ValidationResult validationResult = MobileNumberValidator.validate(input.getMobileNumber());
            if (validationResult.getStatus().equals(ValidationStatus.VALID)) {
                validNumbers.add(ValidationResultMapper.toValidNumber(input, uploadAction));
            } else if (validationResult.getStatus().equals(ValidationStatus.FIXED)) {
                fixedNumbers.add(ValidationResultMapper.toFixedNumber(validationResult, input, uploadAction));
            } else {
                invalidNumbers.add(ValidationResultMapper.toInvalidNumber(validationResult, input, uploadAction));
            }
        }
        validNumberService.saveAll(validNumbers);
        fixedNumberService.saveAll(fixedNumbers);
        invalidNumberService.saveAll(invalidNumbers);
        return ValidationResultMapper.toValidationResultDTO(validNumbers, fixedNumbers, invalidNumbers);
    }

    public ValidationResult validateNumber(String mobileNumber){
        return MobileNumberValidator.validate(mobileNumber);
    }
}
