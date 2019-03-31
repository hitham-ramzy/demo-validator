package com.olx.util;

import com.olx.model.MobileNumberInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    private static MultipartFile file = null;

    @BeforeClass
    public static void beforeClass() throws IOException {
        Path path = Paths.get("src/test/resources/South_African_Mobile_Numbers.csv");
        String name = "South_African_Mobile_Numbers.csv";
        String originalFileName = "South_African_Mobile_Numbers.csv";
        String contentType = "text/plain";
        byte[] content = Files.readAllBytes(path);
        file = new MockMultipartFile(name, originalFileName, contentType, content);
        System.out.println("Starting CSVReaderTest...");
    }


    @Test
    public void readMobileNumbers() throws IOException {
        List<MobileNumberInput> inputs = IOUtil.readMobileNumbers(file);
        assertEquals(inputs.size(), 19);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending CSVReaderTest...");
    }
}
