package com.olx.resources;

import com.olx.model.MobileNumber;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * The type Validation resource.
 */
@RestController()
@RequestMapping("/api/validate")
public class ValidationResource {

    @Autowired
    private ValidationService validationService;

    /**
     * Validate file validation result dto.
     *
     * @param file the file
     * @return the validation result dto
     * @throws IOException the io exception
     */
    @PostMapping("/file")
    public ValidationResultDTO validateFile(@RequestParam("file") MultipartFile file) throws IOException {
        return validationService.validateFile(file);
    }

    /**
     * Validate number mobile number.
     *
     * @param number the number
     * @return the mobile number
     */
    @PostMapping("number")
    public MobileNumber validateNumber(@RequestParam("number") String number) {
        return validationService.validateNumber(number);
    }
}
