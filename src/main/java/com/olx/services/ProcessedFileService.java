package com.olx.services;

import com.olx.model.ProcessedFile;
import com.olx.repositories.ProcessedFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessedFileService {

    @Autowired
    ProcessedFileRepository processedFileRepository;

    public ProcessedFile save(String fileName) {
        ProcessedFile processedFile = new ProcessedFile();
        processedFile.setFileName(fileName);
        return processedFileRepository.save(processedFile);
    }

    public ProcessedFile save(ProcessedFile processedFile) {
        return processedFileRepository.save(processedFile);
    }

    public ProcessedFile findById(Long id) {
        return processedFileRepository.findById(id).orElse(null);
    }
}
