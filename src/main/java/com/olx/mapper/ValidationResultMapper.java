package com.olx.mapper;

import com.olx.model.*;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.model.dto.ValidationStatisticsDTO;

import java.util.List;

public class ValidationResultMapper {

    public static ValidNumber toValidNumber(MobileNumberInput input, UploadAction uploadAction){
        ValidNumber validNumber = new ValidNumber();
        validNumber.setUploadAction(uploadAction);
        validNumber.setId(input.getId());
        validNumber.setMobileNumber(input.getMobileNumber());
        return validNumber;
    }

    public static FixedNumber toFixedNumber(ValidationResult validationResult, MobileNumberInput input, UploadAction uploadAction){
        FixedNumber fixedNumber = new FixedNumber();
        fixedNumber.setUploadAction(uploadAction);
        fixedNumber.setId(input.getId());
        fixedNumber.setMobileNumber(input.getMobileNumber());
        fixedNumber.setWhatWasModified(validationResult.getDescription());
        return fixedNumber;
    }

    public static InvalidNumber toInvalidNumber(ValidationResult validationResult, MobileNumberInput input, UploadAction uploadAction){
        InvalidNumber invalidNumber = new InvalidNumber();
        invalidNumber.setUploadAction(uploadAction);
        invalidNumber.setId(input.getId());
        invalidNumber.setMobileNumber(input.getMobileNumber());
        invalidNumber.setWhyFailed(validationResult.getDescription());
        return invalidNumber;
    }

    public static ValidationResultDTO toValidationResultDTO(List<ValidNumber> validNumbers, List<FixedNumber> fixedNumbers, List<InvalidNumber> invalidNumbers){
        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        validationResultDTO.setValidNumbers(validNumbers);
        validationResultDTO.setFixedNumbers(fixedNumbers);
        validationResultDTO.setInvalidNumbers(invalidNumbers);
        ValidationStatisticsDTO statisticsDTO = new ValidationStatisticsDTO();
        statisticsDTO.setValid(validNumbers.size());
        statisticsDTO.setFixed(fixedNumbers.size());
        statisticsDTO.setInvalid(invalidNumbers.size());
        return validationResultDTO;
    }
}
