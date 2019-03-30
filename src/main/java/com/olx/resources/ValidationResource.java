package com.olx.resources;

import com.olx.model.MobileNumber;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
     * Get latest validation result dto.
     *
     * @return the validation result dto
     */
    @GetMapping("/latest")
    public ValidationResultDTO getLatest(){
        return validationService.getLatest();
    }

    /**
     * Get validation result for specific file by id.
     *
     * @return the validation result dto
     */
    @GetMapping("/{id}")
    public ValidationResultDTO getFileResults(@PathVariable("id") Long id){
        return validationService.getFileResults(id);
    }

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
