package com.olx.util;

import com.olx.model.MobileNumberInput;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    private static MultipartFile multipartFile = null;

    @BeforeClass
    public static void beforeClass() throws IOException {
        multipartFile = TestUtils.loadCSVFile();
    }


    @Test
    public void readMobileNumbers() throws IOException {
        List<MobileNumberInput> inputs = IOUtil.readMobileNumbers(multipartFile);
        assertEquals(19, inputs.size());
    }
}
