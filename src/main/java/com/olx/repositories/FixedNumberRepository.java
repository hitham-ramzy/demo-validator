package com.olx.repositories;

import com.olx.model.FixedNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedNumberRepository extends JpaRepository<FixedNumber, Long> {

    List<FixedNumber> findByUploadActionId(Long uploadActionId);
}
