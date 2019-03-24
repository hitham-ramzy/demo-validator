package com.olx.services;

import com.olx.model.MobileNumberInput;
import com.olx.model.ValidationResult;
import com.olx.model.ValidationStatus;
import com.olx.utils.IOUtil;
import com.olx.utils.MobileNumberValidator;
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

    /**
     * Validate file.
     * This function is for reading the multipart file and validating the numbers
     * @param file the file
     * @throws IOException the io exception
     */
    public Map<String, Object> validateFile(MultipartFile file) throws IOException {

        List<ValidationResult> validNumbers = new ArrayList<>();
        List<ValidationResult> fixedNumbers = new ArrayList<>();
        List<ValidationResult> invalidNumbers = new ArrayList<>();

        // Read the file
        List<MobileNumberInput> inputList = IOUtil.readMobileNumbers(file);
        for (MobileNumberInput input : inputList) {
            ValidationResult validationResult = MobileNumberValidator.validate(input.getMobileNumber());
            validationResult.setSourceId(input.getId());
            validationResult.setMobileNumber(input.getMobileNumber());
            if (validationResult.getStatus().equals(ValidationStatus.VALID)) {
                validNumbers.add(validationResult);
            } else if (validationResult.getStatus().equals(ValidationStatus.FIXED)) {
                fixedNumbers.add(validationResult);
            } else{
                invalidNumbers.add(validationResult);
            }
        }
        Map<String, Object> statisticsMap = new HashMap<>();
        statisticsMap.put(String.valueOf(ValidationStatus.VALID), validNumbers);
        statisticsMap.put(String.valueOf(ValidationStatus.FIXED), fixedNumbers);
        statisticsMap.put(String.valueOf(ValidationStatus.INVALID), invalidNumbers);
        return statisticsMap;
    }
}
