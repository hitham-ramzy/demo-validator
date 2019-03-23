package com.olx.utils;

import com.olx.model.MobileNumberInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static final String COMMA_DELIMITER = ",";

    public static List<MobileNumberInput> readMobileNumbers(String path) throws IOException {

        List<MobileNumberInput> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // To skip the first line of header
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                result.add(new MobileNumberInput(Long.parseLong(values[0]), values[1]));
            }
        }
        return result;
    }
}