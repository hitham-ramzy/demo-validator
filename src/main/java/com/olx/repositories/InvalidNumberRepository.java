package com.olx.repositories;

import com.olx.model.InvalidNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvalidNumberRepository extends JpaRepository<InvalidNumber, Long> {

    List<InvalidNumber> findByUploadActionId(Long uploadActionId);
}
