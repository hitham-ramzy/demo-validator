package com.olx.services;

import com.olx.model.UploadAction;
import com.olx.repositories.UploadActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadActionService {

    @Autowired
    UploadActionRepository uploadActionRepository;

    public UploadAction save(UploadAction validationResult) {
        return uploadActionRepository.save(validationResult);
    }

    public List<UploadAction> findAll() {
        return uploadActionRepository.findAll();
    }

    public UploadAction findOne(Long id) {
        return uploadActionRepository.getOne(id);
    }

}
