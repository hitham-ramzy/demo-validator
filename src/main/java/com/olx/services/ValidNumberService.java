package com.olx.services;

import com.olx.model.ValidNumber;
import com.olx.repositories.ValidNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Valid number service.
 */
@Service
@Transactional
public class ValidNumberService {

    /**
     * The Valid number repository.
     */
    @Autowired
    ValidNumberRepository validNumberRepository;

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<ValidNumber> findAll() {
        return validNumberRepository.findAll();
    }
}
