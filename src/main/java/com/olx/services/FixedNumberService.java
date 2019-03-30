package com.olx.services;

import com.olx.model.FixedNumber;
import com.olx.repositories.FixedNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Fixed number service.
 */
@Service
@Transactional
public class FixedNumberService {

    /**
     * The Fixed number repository.
     */
    @Autowired
    FixedNumberRepository fixedNumberRepository;

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<FixedNumber> findAll() {
        return fixedNumberRepository.findAll();
    }
}
