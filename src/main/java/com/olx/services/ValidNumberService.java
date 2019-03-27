package com.olx.services;

import com.olx.model.ValidNumber;
import com.olx.repositories.ValidNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ValidNumberService {

    @Autowired
    ValidNumberRepository repository;

    public List<ValidNumber> saveAll(List<ValidNumber> validNumbers) {
        return repository.saveAll(validNumbers);
    }

    public List<ValidNumber> findByUploadActionId(final Long uploadActionId) {
        return repository.findByUploadActionId(uploadActionId);
    }
}
