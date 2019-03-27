package com.olx.repositories;

import com.olx.model.ValidNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidNumberRepository extends JpaRepository<ValidNumber, Long> {
}
