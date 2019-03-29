package com.olx.services;

import com.olx.model.MobileNumber;
import com.olx.repositories.MobileNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MobileNumberService {

    @Autowired
    MobileNumberRepository mobileNumberRepository;

    public List<MobileNumber> saveAll(List<MobileNumber> mobileNumbers) {
        return mobileNumberRepository.saveAll(mobileNumbers);
    }

    public MobileNumber findById(Long id) {
        return mobileNumberRepository.findById(id).orElse(null);
    }
}
