package com.olx.util;

import com.olx.model.MobileNumberInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting CSVReaderTest...");
    }


    @Test
    public void readMobileNumbers() throws IOException {
        List<MobileNumberInput> inputs = IOUtil.readMobileNumbers("src/test/java/com/olx/resources/South_African_Mobile_Numbers.csv");
        assertEquals(inputs.size(), 19);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending CSVReaderTest...");
    }
}
