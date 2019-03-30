package com.olx.repositories;

import com.olx.model.ProcessedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Processed file repository.
 */
@Repository
public interface ProcessedFileRepository extends JpaRepository<ProcessedFile, Long> {
    /**
     * get the latest uploaded file.
     *
     * @return the processed file
     */
    ProcessedFile findFirstByOrderByFileIdDesc();

    /**
     * Find by file id processed file.
     *
     * @param id the id
     * @return the processed file
     */
    ProcessedFile findByFileId(Long id);
}
