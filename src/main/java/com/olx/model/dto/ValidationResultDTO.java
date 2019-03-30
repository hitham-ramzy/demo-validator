package com.olx.model.dto;

import com.olx.model.MobileNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Validation result dto.
 */
public class ValidationResultDTO {

    private Long processedFileId;

    private List<MobileNumber> mobileNumbers = new ArrayList<>();

    private ValidationStatisticsDTO statistics;

    /**
     * Gets processed file id.
     *
     * @return the processed file id
     */
    public Long getProcessedFileId() {
        return processedFileId;
    }

    /**
     * Sets processed file id.
     *
     * @param processedFileId the processed file id
     */
    public void setProcessedFileId(Long processedFileId) {
        this.processedFileId = processedFileId;
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
     * Gets statistics.
     *
     * @return the statistics
     */
    public ValidationStatisticsDTO getStatistics() {
        return statistics;
    }

    /**
     * Sets statistics.
     *
     * @param statistics the statistics
     */
    public void setStatistics(ValidationStatisticsDTO statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "ValidationResultDTO{" +
                "processedFileId=" + processedFileId +
                "mobileNumbers=" + mobileNumbers +
                ", statistics=" + statistics +
                '}';
    }
}
