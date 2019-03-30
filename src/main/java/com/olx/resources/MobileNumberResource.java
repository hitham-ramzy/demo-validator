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


@RestController()
@RequestMapping("/api/mobile-number")
public class MobileNumberResource {

    @Autowired
    private MobileNumberService mobileNumberService;

    @GetMapping("/{id}")
    public MobileNumber findMobileNumber(@PathVariable("id") Long id) {
        return mobileNumberService.findById(id);
    }

    @GetMapping("/valid")
    public List<ValidNumber> findValidNumbers() {
        return mobileNumberService.findValidNumbers();
    }

    @GetMapping("/fixed")
    public List<FixedNumber> findFixedNumbers() {
        return mobileNumberService.findFixedNumbers();
    }

    @GetMapping("/invalid")
    public List<InvalidNumber> findInvalidNumbers() {
        return mobileNumberService.findInvalidNumbers();
    }
}
