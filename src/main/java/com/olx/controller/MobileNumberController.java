package com.olx.controller;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.service.MobileNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * The type Mobile number resource.
 */
@RestController()
@RequestMapping("/api/mobile-number")
@Api(value = "MobileNumberController", description = "All data related to saved mobile numbers with their types")
public class MobileNumberController {

    @Autowired
    private MobileNumberService mobileNumberService;

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/all")
    @ApiOperation(value = "List all mobile numbers with all types")
    public List<MobileNumber> findAll() {
        List<MobileNumber> mobileNumbers = mobileNumberService.findAll();
        for (MobileNumber mobileNumber : mobileNumbers) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberController.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        return mobileNumbers;
    }

    /**
     * Find mobile number mobile number.
     *
     * @param id the id
     * @return the mobile number
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get specific mobile number by id")
    public MobileNumber findMobileNumber(@PathVariable("id") Long id) {
        return mobileNumberService.findByMobileId(id);
    }

    /**
     * Find valid numbers list.
     *
     * @return the list
     */
    @GetMapping("/valid")
    @ApiOperation(value = "List VALID mobile numbers")
    public List<ValidNumber> findValidNumbers() {
        List<ValidNumber> validNumbers = mobileNumberService.findValidNumbers();
        for (MobileNumber mobileNumber : validNumbers) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberController.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        return validNumbers;
    }

    /**
     * Find fixed numbers list.
     *
     * @return the list
     */
    @GetMapping("/fixed")
    @ApiOperation(value = "List FIXED mobile numbers")
    public List<FixedNumber> findFixedNumbers() {
        List<FixedNumber> fixedNumbers = mobileNumberService.findFixedNumbers();
        for (MobileNumber mobileNumber : fixedNumbers) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberController.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        return fixedNumbers;
    }

    /**
     * Find invalid numbers list.
     *
     * @return the list
     */
    @GetMapping("/invalid")
    @ApiOperation(value = "List INVALID mobile numbers")
    public List<InvalidNumber> findInvalidNumbers() {
        List<InvalidNumber> invalidNumbers = mobileNumberService.findInvalidNumbers();
        for (MobileNumber mobileNumber : invalidNumbers) {
            Link selfLink = ControllerLinkBuilder.linkTo(methodOn(MobileNumberController.class)
                    .findMobileNumber(mobileNumber.getMobileId())).withSelfRel();
            mobileNumber.add(selfLink);
        }
        return invalidNumbers;
    }
}
