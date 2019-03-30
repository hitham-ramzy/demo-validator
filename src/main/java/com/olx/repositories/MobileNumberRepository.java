package com.olx.repositories;

import com.olx.model.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Mobile number repository.
 */
@Repository
public interface MobileNumberRepository extends JpaRepository<MobileNumber, Long> {
    /**
     * Delete by id in.
     *
     * @param collect the collect
     */
    void deleteByIdIn(List<Long> collect);

    /**
     * Find by processed file id list.
     *
     * @param id the id
     * @return the list of mobile numbers
     */
    List<MobileNumber> findByProcessedFileId(Long id);
}
