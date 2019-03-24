package com.olx.services;

import com.olx.model.FixedNumber;
import com.olx.repositories.FixedNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedNumberService {

    @Autowired
    FixedNumberRepository repository;

    public List<FixedNumber> saveAll(List<FixedNumber> fixedNumbers) {
        return repository.saveAll(fixedNumbers);
    }
}
