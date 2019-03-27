package com.olx.resources;

import com.olx.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.NotSupportedException;
import java.io.IOException;
import java.util.Map;


@RestController("/api/validate")
public class ValidationResource {

    @Autowired
    private ValidationService validationService;

    @PostMapping("file")
    public Map<String, Object> validateFile(@RequestParam("file") MultipartFile file) throws IOException {
        return validationService.validateFileAndSave(file);
    }

    // TODO :: Implement this resource
    @PostMapping("number")
    public Object validateNumber(@RequestParam("number") Long number) throws NotSupportedException {
        throw new NotSupportedException();
    }
}
