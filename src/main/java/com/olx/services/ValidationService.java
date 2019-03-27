package com.olx.services;

import com.olx.mapper.ValidationMapper;
import com.olx.model.MobileNumber;
import com.olx.model.MobileNumberInput;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.utils.IOUtil;
import com.olx.utils.MobileNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Validation service.
 */
@Service
public class ValidationService {
    @Autowired
    MobileNumberService mobileNumberService;

    /**
     * Validate file.
     * This function is for reading the multipart file and validating the numbers
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public ValidationResultDTO validateFile(MultipartFile file) throws IOException {

        List<MobileNumber> mobileNumbers = new ArrayList<>();

        // Read the file
        List<MobileNumberInput> inputList = IOUtil.readMobileNumbers(file);
        for (MobileNumberInput input : inputList) {
            MobileNumber mobileNumber = MobileNumberValidator.validate(input.getMobileNumber());
            mobileNumber.setId(input.getId());
            mobileNumbers.add(mobileNumber);
        }
        return ValidationMapper.fromMobileNumbers(mobileNumberService.saveAll(mobileNumbers));
    }

    public MobileNumber validateNumber(String mobileNumber){
        return MobileNumberValidator.validate(mobileNumber);
    }
}
