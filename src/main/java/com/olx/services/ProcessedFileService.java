package com.olx.services;

import com.olx.model.ProcessedFile;
import com.olx.repositories.ProcessedFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Processed file service.
 */
@Service
@Transactional
public class ProcessedFileService {

    /**
     * The Processed file repository.
     */
    @Autowired
    ProcessedFileRepository processedFileRepository;

    /**
     * Save processed file.
     *
     * @param fileName the file name
     * @return the processed file
     */
    public ProcessedFile save(String fileName) {
        ProcessedFile processedFile = new ProcessedFile();
        processedFile.setFileName(fileName);
        return processedFileRepository.save(processedFile);
    }

    /**
     * Save processed file.
     *
     * @param processedFile the processed file
     * @return the processed file
     */
    public ProcessedFile save(ProcessedFile processedFile) {
        return processedFileRepository.save(processedFile);
    }

    /**
     * Find by id processed file.
     *
     * @param id the id
     * @return the processed file
     */
    public ProcessedFile findById(Long id) {
        return processedFileRepository.findById(id).orElse(null);
    }

    /**
     * Gets latest.
     *
     * @return the latest file uploaded
     */
    public ProcessedFile getLatest() {
        return processedFileRepository.findFirstByOrderByIdDesc();
    }
}
