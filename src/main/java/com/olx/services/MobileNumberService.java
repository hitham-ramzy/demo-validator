package com.olx.services;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.repositories.MobileNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MobileNumberService {

    @Autowired
    ValidNumberService validNumberService;

    @Autowired
    FixedNumberService fixedNumberService;

    @Autowired
    InvalidNumberService invalidNumberService;

    @Autowired
    MobileNumberRepository mobileNumberRepository;

    public List<MobileNumber> saveAll(List<MobileNumber> mobileNumbers) {
        return mobileNumberRepository.saveAll(mobileNumbers);
    }

    public MobileNumber findById(Long id) {
        return mobileNumberRepository.findById(id).orElse(null);
    }

    public List<ValidNumber> findValidNumbers() {
        return validNumberService.findAll();
    }

    public List<FixedNumber> findFixedNumbers() {
        return fixedNumberService.findAll();
    }

    public List<InvalidNumber> findInvalidNumbers() {
        return invalidNumberService.findAll();
    }
}
