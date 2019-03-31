package com.olx.repository;

import com.olx.model.ValidNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidNumberRepository extends JpaRepository<ValidNumber, Long> {

}
