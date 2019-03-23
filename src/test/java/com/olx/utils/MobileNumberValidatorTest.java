package com.olx.utils;

import com.olx.model.ValidationStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(MobileNumberValidator.validate("27717278645").getStatus(), ValidationStatus.VALID);
        assertEquals(MobileNumberValidator.validate("27823871495").getStatus(), ValidationStatus.VALID);
        assertEquals(MobileNumberValidator.validate("6478342944").getStatus(), ValidationStatus.INVALID);
        assertEquals(MobileNumberValidator.validate("_DELETED_1488176172").getStatus(), ValidationStatus.INVALID);
        assertEquals(MobileNumberValidator.validate("478342944").getStatus(), ValidationStatus.FIXED);
        assertEquals(MobileNumberValidator.validate("8682211HItham91").getStatus(), ValidationStatus.FIXED);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending MobileNumberValidatorTest...");
    }

}
