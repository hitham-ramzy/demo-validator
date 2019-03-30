package com.olx.resources;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.services.MobileNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * The type Mobile number resource.
 */
@RestController()
@RequestMapping("/api/mobile-number")
public class MobileNumberResource {

    @Autowired
    private MobileNumberService mobileNumberService;

    /**
     * Find mobile number mobile number.
     *
     * @param id the id
     * @return the mobile number
     */
    @GetMapping("/{id}")
    public MobileNumber findMobileNumber(@PathVariable("id") Long id) {
        return mobileNumberService.findById(id);
    }

    /**
     * Find valid numbers list.
     *
     * @return the list
     */
    @GetMapping("/valid")
    public List<ValidNumber> findValidNumbers() {
        return mobileNumberService.findValidNumbers();
    }

    /**
     * Find fixed numbers list.
     *
     * @return the list
     */
    @GetMapping("/fixed")
    public List<FixedNumber> findFixedNumbers() {
        return mobileNumberService.findFixedNumbers();
    }

    /**
     * Find invalid numbers list.
     *
     * @return the list
     */
    @GetMapping("/invalid")
    public List<InvalidNumber> findInvalidNumbers() {
        return mobileNumberService.findInvalidNumbers();
    }
}
