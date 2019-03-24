package com.olx.services;

import com.olx.model.InvalidNumber;
import com.olx.repositories.InvalidNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvalidNumberService {

    @Autowired
    InvalidNumberRepository repository;

    public List<InvalidNumber> saveAll(List<InvalidNumber> invalidNumbers) {
        return repository.saveAll(invalidNumbers);
    }
}
