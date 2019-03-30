package com.olx.resources;

import com.olx.model.MobileNumber;
import com.olx.model.dto.ValidationResultDTO;
import com.olx.services.ValidationService;
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
public class ValidationResource {

    @Autowired
    private ValidationService validationService;

    /**
     * Get latest validation result dto.
     *
     * @return the validation result dto
     */
    @GetMapping("/latest")
    public Resource<ValidationResultDTO> getLatest() {
        return addHateoasLinks(validationService.getLatest());
    }

    /**
     * Get validation result for specific file by id.
     *
     * @return the validation result dto
     */
    @GetMapping("/{id}")
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
    public MobileNumber validateNumber(@RequestParam("number") String number) {
        return validationService.validateNumber(number);
    }

    private Resource<ValidationResultDTO> addHateoasLinks(ValidationResultDTO validationResultDTO) {
        for (MobileNumber mobileNumber : validationResultDTO.getMobileNumbers()) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberResource.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        Link link = ControllerLinkBuilder.linkTo(methodOn(ValidationResource.class)
                .getFileResults(validationResultDTO.getProcessedFile().getFileId())).withSelfRel();
        return new Resource<>(validationResultDTO, link);
    }
}
