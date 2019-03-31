package com.olx.controller;

import com.olx.model.MobileNumber;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.service.ValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * The type Validation resource.
 */
@RestController()
@RequestMapping("/api/validate")
@Api(value = "ValidationController", description = "All data related to validating numbers")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    /**
     * Get latest validation result dto.
     *
     * @return the validation result dto
     */
    @GetMapping("/latest")
    @ApiOperation(value = "Get the result of the last file validated")
    public Resource<ValidationResultDTO> getLatest() {
        return addHateoasLinks(validationService.getLatest());
    }

    /**
     * Get validation result for specific file by id.
     *
     * @return the validation result dto
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get the result for specific file by it's id")
    public Resource<ValidationResultDTO> getFileResults(@PathVariable("id") Long id) {
        return addHateoasLinks(validationService.getFileResults(id));
    }

    /**
     * Validate file validation result dto.
     *
     * @param file the file
     * @return the validation result dto
     * @throws IOException the io exception
     */
    @PostMapping("/file")
    @ApiOperation(value = "Validate a CSV by uploading it")
    public Resource<ValidationResultDTO> validateFile(@RequestParam("file") MultipartFile file) throws IOException {
        return addHateoasLinks(validationService.validateFile(file));
    }

    /**
     * Validate number mobile number.
     *
     * @param number the number
     * @return the mobile number
     */
    @PostMapping("number")
    @ApiOperation(value = "Validate one single mobile number")
    public MobileNumber validateNumber(@RequestParam("number") String number) {
        return validationService.validateNumber(number);
    }

    private Resource<ValidationResultDTO> addHateoasLinks(ValidationResultDTO validationResultDTO) {
        for (MobileNumber mobileNumber : validationResultDTO.getMobileNumbers()) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberController.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        Link link = ControllerLinkBuilder.linkTo(methodOn(ValidationController.class)
                .getFileResults(validationResultDTO.getProcessedFile().getFileId())).withSelfRel();
        return new Resource<>(validationResultDTO, link);
    }
}
