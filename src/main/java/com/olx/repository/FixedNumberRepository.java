package com.olx.repository;

import com.olx.model.FixedNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedNumberRepository extends JpaRepository<FixedNumber, Long> {

}
