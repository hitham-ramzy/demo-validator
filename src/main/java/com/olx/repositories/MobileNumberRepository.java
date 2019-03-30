package com.olx.repositories;

import com.olx.model.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    void deleteByMobileIdIn(List<Long> collect);

    /**
     * Find by processed file id list.
     *
     * @param id the id
     * @return the list of mobile numbers
     */
    List<MobileNumber> findByProcessedFileFileId(Long id);

    /**
     * Find by mobile id optional.
     *
     * @param id the id
     * @return the optional
     */
    MobileNumber findByMobileId(Long id);
}
