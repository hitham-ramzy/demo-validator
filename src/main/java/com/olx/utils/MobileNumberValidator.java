package com.olx.utils;

import com.olx.model.ValidationResult;
import com.olx.model.ValidationStatus;

import java.util.regex.Pattern;

public class MobileNumberValidator {

    /**
     * The Constant ZA_MOBILE_NUMBER_REGEX_PATTERN.
     */
    private static final Pattern ZA_MOBILE_NUMBER_REGEX_PATTERN = Pattern.compile("^((?:\\+27|(00)?27)|0)([1-9])(\\d{8})$");

    public static Boolean isValid(String mobileNumber) {
        return ZA_MOBILE_NUMBER_REGEX_PATTERN.matcher(mobileNumber).matches();
    }

    public static ValidationResult validate(String mobileNumber) {
        if (isValid(mobileNumber)) {
            return new ValidationResult(ValidationStatus.VALID);
        }

//        Trying to FIX the input
        String description = "";
        String fixedMobileNumber = mobileNumber.replaceAll("\\D+", "");
        if (mobileNumber.length() != fixedMobileNumber.length()) {
            description = description.concat("removing Not digits from number");
        }

        if (fixedMobileNumber.length() == 9) {
            fixedMobileNumber = "27".concat(fixedMobileNumber);
            if (description.length() > 0) description = description.concat(" and ");
            description = description.concat("adding 27 before the number");
        }
        if (isValid(fixedMobileNumber)) {
            ValidationResult validationResult = new ValidationResult(ValidationStatus.FIXED);
            validationResult.setDescription(description);
            validationResult.setFixedMobileNumber(fixedMobileNumber);
            return validationResult;
        }
        return new ValidationResult(ValidationStatus.INVALID);
    }
}
