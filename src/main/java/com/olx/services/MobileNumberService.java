package com.olx.services;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.MobileNumber;
import com.olx.model.ValidNumber;
import com.olx.repositories.MobileNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * Save mobile number.
     *
     * @param mobileNumbers the mobile numbers
     * @return the mobile number
     */
    public MobileNumber save(MobileNumber mobileNumbers) {
        return mobileNumberRepository.save(mobileNumbers);
    }

    /**
     * Update mobile number.
     * <p>
     * This function is resolving the problem of updating DiscriminatorColumn in JPA
     * by removing th old number and recreating it with the new status
     *
     * @param mobileNumbers the mobile numbers
     * @return the mobile number
     */
    public MobileNumber update(MobileNumber mobileNumbers) {
        mobileNumberRepository.deleteById(mobileNumbers.getId());
        return mobileNumberRepository.save(mobileNumbers);
    }

    /**
     * Find by id mobile number.
     *
     * @param id the id
     * @return the mobile number
     */
    public MobileNumber findById(Long id) {
        return mobileNumberRepository.findById(id).orElse(null);
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
