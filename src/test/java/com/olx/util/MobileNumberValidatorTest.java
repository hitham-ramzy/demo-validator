package com.olx.util;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.ValidNumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MobileNumberValidatorTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting MobileNumberValidatorTest...");
    }

    @Test
    public void isValid() {
        assertTrue(MobileNumberValidator.isValid("27717278645"));
        assertTrue(MobileNumberValidator.isValid("27823871495"));
        assertFalse(MobileNumberValidator.isValid("6478342944"));
        assertFalse(MobileNumberValidator.isValid("_DELETED_1488176172"));
        assertFalse(MobileNumberValidator.isValid("868221191"));
    }

    @Test
    public void getValidationResult() {
        assertTrue(MobileNumberValidator.validate("27717278645") instanceof ValidNumber);
        assertTrue(MobileNumberValidator.validate("27823871495") instanceof ValidNumber);
        assertTrue(MobileNumberValidator.validate("6478342944") instanceof InvalidNumber);
        assertTrue(MobileNumberValidator.validate("_DELETED_1488176172") instanceof InvalidNumber);
        assertTrue(MobileNumberValidator.validate("478342944") instanceof FixedNumber);
        assertTrue(MobileNumberValidator.validate("8682211HItham91") instanceof InvalidNumber);
        assertTrue(MobileNumberValidator.validate("263734101094") instanceof FixedNumber);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending MobileNumberValidatorTest...");
    }

}
