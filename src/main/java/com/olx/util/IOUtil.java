package com.olx.util;

import com.olx.model.MobileNumberInput;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The IOUtil class.
 * any function related to read or write from from the disk should be here
 *
 */
public class IOUtil {

    private static final String COMMA_DELIMITER = ",";

    /**
     * Read mobile numbers list from the CSV file
     *
     * @param path the path
     * @return the list
     * @throws IOException the io exception
     */
    public static List<MobileNumberInput> readMobileNumbers(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        return readCSV(bufferedReader);
    }

    /**
     * Read mobile numbers list from a multipart file.
     *
     * @param multipartFile the multipart file
     * @return the list
     * @throws IOException the io exception
     */
    public static List<MobileNumberInput> readMobileNumbers(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return readCSV(bufferedReader);
    }

    private static List<MobileNumberInput> readCSV(BufferedReader bufferedReader) throws IOException {
        String line;
        List<MobileNumberInput> result = new ArrayList<>();
        bufferedReader.readLine(); // To skip the first line of header
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            result.add(new MobileNumberInput(Long.parseLong(values[0]), values[1]));
        }
        return result;
    }
}