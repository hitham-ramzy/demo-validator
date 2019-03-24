package com.olx.repositories;

import com.olx.model.ValidNumber;
import com.olx.model.ValidationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidNumberRepository extends JpaRepository<ValidNumber, Long> {

}
