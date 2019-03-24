package com.olx.repositories;

import com.olx.model.InvalidNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidNumberRepository extends JpaRepository<InvalidNumber, Long> {

}
