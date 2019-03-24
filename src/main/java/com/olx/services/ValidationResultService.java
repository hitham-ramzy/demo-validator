package com.olx.services;

import com.olx.model.ValidationResult;
import com.olx.repositories.ValidationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationResultService {

    @Autowired
    ValidationResultRepository validationResultRepository;

    public ValidationResult save(ValidationResult validationResult) {
        return validationResultRepository.save(validationResult);
    }

    public List<ValidationResult> findAll() {
        return validationResultRepository.findAll();
    }

    public ValidationResult findOne(Long id) {
        return validationResultRepository.getOne(id);
    }

    public void delete(Long id) {
        ValidationResult validationResult = findOne(id);
        if (validationResult != null){
            validationResultRepository.delete(validationResult);
        }
    }

}
