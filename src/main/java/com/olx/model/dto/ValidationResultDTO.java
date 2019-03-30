package com.olx.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.olx.model.MobileNumber;
import com.olx.model.ProcessedFile;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Validation result dto.
 */
public class ValidationResultDTO extends ResourceSupport {

    private ProcessedFile processedFile;

    private List<MobileNumber> mobileNumbers = new ArrayList<>();

    @JsonIgnore
    private List<MobileNumber> numbersToCreate = new ArrayList<>();

    @JsonIgnore
    private List<MobileNumber> numbersToUpdate = new ArrayList<>();

    /**
     * Gets processed file id.
     *
     * @return the processed file id
     */
    public ProcessedFile getProcessedFile() {
        return processedFile;
    }

    /**
     * Sets processed file id.
     *
     * @param processedFile the processed file id
     */
    public void setProcessedFile(ProcessedFile processedFile) {
        this.processedFile = processedFile;
    }

    /**
     * Gets mobile numbers.
     *
     * @return the mobile numbers
     */
    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    /**
     * Sets mobile numbers.
     *
     * @param mobileNumbers the mobile numbers
     */
    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    /**
     * Gets numbers to create.
     *
     * @return the numbers to create
     */
    public List<MobileNumber> getNumbersToCreate() {
        return numbersToCreate;
    }

    /**
     * Sets numbers to create.
     *
     * @param numbersToCreate the numbers to create
     */
    public void setNumbersToCreate(List<MobileNumber> numbersToCreate) {
        this.numbersToCreate = numbersToCreate;
    }

    /**
     * Gets numbers to update.
     *
     * @return the numbers to update
     */
    public List<MobileNumber> getNumbersToUpdate() {
        return numbersToUpdate;
    }

    /**
     * Sets numbers to update.
     *
     * @param numbersToUpdate the numbers to update
     */
    public void setNumbersToUpdate(List<MobileNumber> numbersToUpdate) {
        this.numbersToUpdate = numbersToUpdate;
    }

    @Override
    public String toString() {
        return "ValidationResultDTO{" +
                "processedFile=" + processedFile +
                "mobileNumbers=" + mobileNumbers +
                '}';
    }
}
