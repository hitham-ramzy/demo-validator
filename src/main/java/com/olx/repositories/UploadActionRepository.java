package com.olx.repositories;

import com.olx.model.UploadAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadActionRepository extends JpaRepository<UploadAction, Long> {

}
