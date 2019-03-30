package com.olx.services;

import com.olx.model.InvalidNumber;
import com.olx.repositories.InvalidNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Invalid number service.
 */
@Service
@Transactional
public class InvalidNumberService {

    /**
     * The Invalid number repository.
     */
    @Autowired
    InvalidNumberRepository invalidNumberRepository;

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<InvalidNumber> findAll() {
        return invalidNumberRepository.findAll();
    }
}
