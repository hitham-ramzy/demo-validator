package com.olx.services;

import com.olx.model.UploadAction;
import com.olx.repositories.UploadActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UploadActionService {

    @Autowired
    UploadActionRepository uploadActionRepository;

    public UploadAction save(UploadAction validationResult) {
        return uploadActionRepository.save(validationResult);
    }

    public List<UploadAction> findAll() {
        return uploadActionRepository.findAll();
    }

    public UploadAction findById(Long id) {
        return uploadActionRepository.findById(id).orElse(null);
    }

    public UploadAction findLatest() {
        return uploadActionRepository.findTopByOrderByIdDesc();
    }
}
