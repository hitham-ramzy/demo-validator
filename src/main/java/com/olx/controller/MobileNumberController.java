package com.olx.controller;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.service.MobileNumberService;
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
public class MobileNumberController {

    @Autowired
    private MobileNumberService mobileNumberService;

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/")
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
    public MobileNumber findMobileNumber(@PathVariable("id") Long id) {
        return mobileNumberService.findByMobileId(id);
    }

    /**
     * Find valid numbers list.
     *
     * @return the list
     */
    @GetMapping("/valid")
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
