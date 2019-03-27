package com.olx.utils;

import com.olx.model.ValidationResult;
import com.olx.model.ValidationStatus;

import java.util.regex.Pattern;

public class MobileNumberValidator {

    /**
     * The Constant ZA_MOBILE_NUMBER_REGEX_PATTERN.
     */
    private static final Pattern ZA_MOBILE_NUMBER_REGEX_PATTERN = Pattern.compile("^((?:\\+27|(00)?27)|0)([1-9])(\\d{8})$");

    private static final String COUNTRY_CODE = "27";

    private static final String AND = " and ";

    private static final String ADD_COUNTRY_CODE = "Adding the country code";

    private static final String FIX_COUNTRY_CODE = "Fixing the country code";

    private static final String FIX_BY_REMOVING_DELETED = "Fixing by removing deleted text";

    private static final String FAILED_LONG_NUMBER = "Long mobile number";

    private static final String FAILED_SHORT_NUMBER = "Short mobile number";

    private static final String FAILED_TOTALLY_WRONG_NUMBER = "Totally wrong number";

    static Boolean isValid(String mobileNumber) {
        return ZA_MOBILE_NUMBER_REGEX_PATTERN.matcher(mobileNumber).matches();
    }

    public static ValidationResult validate(String mobileNumber) {
        if (isValid(mobileNumber)) {
            return createValidationResult(ValidationStatus.VALID, null, null);
        }

//        Trying to FIX the input
        if (mayBeWrongCode(mobileNumber)) {
            if (mobileNumber.length() == 11) {
                return createValidationResult(ValidationStatus.FIXED, mobileNumber.replace(mobileNumber.charAt(1), '7'), FIX_COUNTRY_CODE);
            } else if (mobileNumber.length() >= 12) {
                String fixedNumber = mobileNumber.replace(mobileNumber.charAt(1), '7').substring(0, 12);
                return createValidationResult(ValidationStatus.FIXED, fixedNumber, FIX_BY_REMOVING_DELETED + AND + FIX_COUNTRY_CODE);
            }
        } else if (mobileNumber.contains("DELETED")) {
            String[] numbers = mobileNumber.split("_DELETED_");
            for (String number : numbers) {
                if (isValid(mobileNumber)) {
                    return createValidationResult(ValidationStatus.FIXED, number, FIX_BY_REMOVING_DELETED);
                } else if (mayBeWrongCode(mobileNumber) && mobileNumber.length() >= 12) {
                    String fixedNumber = mobileNumber.replace(mobileNumber.charAt(1), '7').substring(0, 12);
                    return createValidationResult(ValidationStatus.FIXED, fixedNumber, FIX_BY_REMOVING_DELETED + AND + FIX_COUNTRY_CODE);
                }
            }
        } else if (mobileNumber.length() == 9) {
            return createValidationResult(ValidationStatus.FIXED, COUNTRY_CODE + mobileNumber, ADD_COUNTRY_CODE);
        } else if (mobileNumber.length() > 12) {
            return createValidationResult(ValidationStatus.INVALID, null, FAILED_LONG_NUMBER);
        } else if (mobileNumber.length() < 12) {
            return createValidationResult(ValidationStatus.INVALID, null, FAILED_SHORT_NUMBER);
        }
        return createValidationResult(ValidationStatus.INVALID, null, FAILED_TOTALLY_WRONG_NUMBER);
    }

    private static ValidationResult createValidationResult(ValidationStatus status, String fixedNumber, String description) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setStatus(status);
        validationResult.setFixedNumber(fixedNumber);
        validationResult.setDescription(description);
        return validationResult;
    }

    private static Boolean mayBeWrongCode(String mobileNumber) {
        return mobileNumber.startsWith("2");
    }
}
