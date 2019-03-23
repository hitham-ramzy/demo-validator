package com.olx.resources;

import com.olx.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController("/")
public class ValidationResource {

    @Autowired
    private ValidationService validationService;

    @PostMapping("validate")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        validationService.validateFile(file);
    }
}
