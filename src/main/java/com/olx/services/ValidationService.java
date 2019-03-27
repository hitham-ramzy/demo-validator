package com.olx.services;

import com.olx.model.*;
import com.olx.utils.IOUtil;
import com.olx.utils.MobileNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> validateFileAndSave(MultipartFile file) throws IOException {

        List<ValidNumber> validNumbers = new ArrayList<>();
        List<FixedNumber> fixedNumbers = new ArrayList<>();
        List<InvalidNumber> invalidNumbers = new ArrayList<>();

        // Read the file
        List<MobileNumberInput> inputList = IOUtil.readMobileNumbers(file);
        UploadAction uploadAction = uploadActionService.save(new UploadAction());
        for (MobileNumberInput input : inputList) {
            ValidationResult validationResult = MobileNumberValidator.validate(input.getMobileNumber());
            if (validationResult.getStatus().equals(ValidationStatus.VALID)) {
                ValidNumber validNumber = new ValidNumber();
                validNumber.setUploadAction(uploadAction);
                validNumber.setId(input.getId());
                validNumber.setMobileNumber(input.getMobileNumber());
                validNumbers.add(validNumber);
            } else if (validationResult.getStatus().equals(ValidationStatus.FIXED)) {
                FixedNumber fixedNumber = new FixedNumber();
                fixedNumber.setUploadAction(uploadAction);
                fixedNumber.setId(input.getId());
                fixedNumber.setMobileNumber(validationResult.getFixedMobileNumber());
                fixedNumber.setWhatWasModified(validationResult.getDescription());
                fixedNumbers.add(fixedNumber);
            } else {
                InvalidNumber invalidNumber = new InvalidNumber();
                invalidNumber.setUploadAction(uploadAction);
                invalidNumber.setId(input.getId());
                invalidNumber.setMobileNumber(input.getMobileNumber());
                invalidNumbers.add(invalidNumber);
            }
        }
        validNumberService.saveAll(validNumbers);
        fixedNumberService.saveAll(fixedNumbers);
        invalidNumberService.saveAll(invalidNumbers);

        Map<String, Object> statisticsMap = new HashMap<>();
        statisticsMap.put(String.valueOf(ValidationStatus.VALID), validNumbers);
        statisticsMap.put(String.valueOf(ValidationStatus.FIXED), fixedNumbers);
        statisticsMap.put(String.valueOf(ValidationStatus.INVALID), invalidNumbers);
        return statisticsMap;
    }
}
