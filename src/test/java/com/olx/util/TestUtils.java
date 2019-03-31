package com.olx.util;

import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

    public static MockMultipartFile loadCSVFile() throws IOException {
        Path path = Paths.get("src/test/resources/South_African_Mobile_Numbers.csv");
        String name = "South_African_Mobile_Numbers.csv";
        String originalFileName = "South_African_Mobile_Numbers.csv";
        String contentType = "text/plain";
        byte[] content = Files.readAllBytes(path);
        return new MockMultipartFile(name, originalFileName, contentType, content);
    }
}
