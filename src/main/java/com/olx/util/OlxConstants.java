package com.olx.util;

import java.util.regex.Pattern;

class OlxConstants {

    static final String COMMA_DELIMITER = ",";

    static final Pattern ZA_MOBILE_NUMBER_REGEX_PATTERN = Pattern.compile("^((?:\\+27|(00)?27)|0)([1-9])(\\d{8})$");

    static final String COUNTRY_CODE = "27";

    static final String AND = " and ";

    static final String ADD_COUNTRY_CODE = "Adding the country code";

    static final String FIX_COUNTRY_CODE = "Fixing the country code";

    static final String FIX_BY_REMOVING_DELETED = "Fixing by removing deleted text";

    static final String FAILED_LONG_NUMBER = "Long mobile number";

    static final String FAILED_SHORT_NUMBER = "Short mobile number";

    static final String FAILED_TOTALLY_WRONG_NUMBER = "Totally wrong number";

}
