package com.olx.services;

import com.olx.model.ValidNumber;
import com.olx.repositories.ValidNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidNumberService {

    @Autowired
    ValidNumberRepository repository;

    public List<ValidNumber> saveAll(List<ValidNumber> validNumbers) {
        return repository.saveAll(validNumbers);
    }
}
