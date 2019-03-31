package com.olx.util;

import com.olx.model.*;

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

    public static MobileNumber validate(MobileNumberInput input) {
        MobileNumber mobileNumber = validate(input.getMobileNumber());
        mobileNumber.setMobileId(input.getId());
        return mobileNumber;
    }

    public static MobileNumber validate(String mobileNumber) {
        if (isValid(mobileNumber)) {
            return createValidNumber(mobileNumber);
        }

//        Trying to FIX the input
        if (mayBeWrongCode(mobileNumber)) {
            if (mobileNumber.length() == 11) {
                return createFixedNumber(mobileNumber.replace(mobileNumber.charAt(1), '7'), FIX_COUNTRY_CODE);
            } else if (mobileNumber.length() >= 12) {
                String fixedNumber = mobileNumber.replace(mobileNumber.charAt(1), '7').substring(0, 12);
                return createFixedNumber(fixedNumber, FIX_BY_REMOVING_DELETED + AND + FIX_COUNTRY_CODE);
            }
        } else if (mobileNumber.contains("DELETED")) {
            String[] numbers = mobileNumber.split("_DELETED_");
            for (String number : numbers) {
                if (isValid(mobileNumber)) {
                    return createFixedNumber(number, FIX_BY_REMOVING_DELETED);
                } else if (mayBeWrongCode(mobileNumber) && mobileNumber.length() >= 12) {
                    String fixedNumber = mobileNumber.replace(mobileNumber.charAt(1), '7').substring(0, 12);
                    return createFixedNumber(fixedNumber, FIX_BY_REMOVING_DELETED + AND + FIX_COUNTRY_CODE);
                }
            }
        } else if (mobileNumber.length() == 9) {
            return createFixedNumber(COUNTRY_CODE + mobileNumber, ADD_COUNTRY_CODE);
        } else if (mobileNumber.length() > 12) {
            return createInvalidNumber(mobileNumber, FAILED_LONG_NUMBER);
        } else if (mobileNumber.length() < 12) {
            return createInvalidNumber(mobileNumber, FAILED_SHORT_NUMBER);
        }
        return createInvalidNumber(mobileNumber, FAILED_TOTALLY_WRONG_NUMBER);
    }

    private static ValidNumber createValidNumber(String mobileNumber) {
        ValidNumber validNumber = new ValidNumber();
        validNumber.setMobileNumber(mobileNumber);
        return validNumber;
    }

    private static FixedNumber createFixedNumber(String mobileNumber, String whatWasModified) {
        FixedNumber fixedNumber = new FixedNumber();
        fixedNumber.setMobileNumber(mobileNumber);
        fixedNumber.setWhatWasModified(whatWasModified);
        return fixedNumber;
    }

    private static InvalidNumber createInvalidNumber(String mobileNumber, String whyFailed) {
        InvalidNumber invalidNumber = new InvalidNumber();
        invalidNumber.setMobileNumber(mobileNumber);
        invalidNumber.setWhyFailed(whyFailed);
        return invalidNumber;
    }

    private static Boolean mayBeWrongCode(String mobileNumber) {
        return mobileNumber.startsWith("2");
    }
}
