package com.olx.service;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.repository.MobileNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Mobile number service.
 */
@Service
@Transactional
public class MobileNumberService {

    /**
     * The Valid number service.
     */
    @Autowired
    ValidNumberService validNumberService;

    /**
     * The Fixed number service.
     */
    @Autowired
    FixedNumberService fixedNumberService;

    /**
     * The Invalid number service.
     */
    @Autowired
    InvalidNumberService invalidNumberService;

    /**
     * The Mobile number repository.
     */
    @Autowired
    MobileNumberRepository mobileNumberRepository;

    /**
     * Save all list.
     *
     * @param mobileNumbers the mobile numbers
     * @return the list
     */
    public List<MobileNumber> saveAll(List<MobileNumber> mobileNumbers) {
        return mobileNumberRepository.saveAll(mobileNumbers);
    }

    /**
     * Update All ِmobile numbers.
     * <p>
     * This function is resolving the problem of updating DiscriminatorColumn in JPA
     * by removing the old numbers and recreating them with the new status
     *
     * @param mobileNumbers the mobile numbers
     * @return the list of mobile numbers
     */
    public List<MobileNumber> updateAll(List<MobileNumber> mobileNumbers) {
        mobileNumberRepository.deleteByMobileIdIn(mobileNumbers.stream().map(MobileNumber::getMobileId).collect(Collectors.toList()));
        return mobileNumberRepository.saveAll(mobileNumbers);
    }

    /**
     * Find all list.
     *
     * @return the list of all numbers
     */
    public List<MobileNumber> findAll() {
        return mobileNumberRepository.findAll();
    }

    /**
     * Find by id mobile number.
     *
     * @param id the id
     * @return the mobile number
     */
    public MobileNumber findByMobileId(Long id) {
        return mobileNumberRepository.findByMobileId(id);
    }

    /**
     * Find by file id list.
     *
     * @param id the id
     * @return the list
     */
    public List<MobileNumber> findByFileId(Long id) {
        return mobileNumberRepository.findByProcessedFileFileId(id);
    }

    /**
     * Find valid numbers list.
     *
     * @return the list
     */
    public List<ValidNumber> findValidNumbers() {
        return validNumberService.findAll();
    }

    /**
     * Find fixed numbers list.
     *
     * @return the list
     */
    public List<FixedNumber> findFixedNumbers() {
        return fixedNumberService.findAll();
    }

    /**
     * Find invalid numbers list.
     *
     * @return the list
     */
    public List<InvalidNumber> findInvalidNumbers() {
        return invalidNumberService.findAll();
    }
}
