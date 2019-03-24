package com.olx.repositories;

import com.olx.model.ValidationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationResultRepository extends JpaRepository<ValidationResult, Long> {

}
