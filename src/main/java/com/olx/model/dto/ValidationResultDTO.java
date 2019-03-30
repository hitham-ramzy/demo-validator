package com.olx.model.dto;

import com.olx.model.MobileNumber;

import java.util.ArrayList;
import java.util.List;

public class ValidationResultDTO {

    private Long processedFileId;

    private List<MobileNumber> mobileNumbers = new ArrayList<>();

    private ValidationStatisticsDTO statistics;

    public Long getProcessedFileId() {
        return processedFileId;
    }

    public void setProcessedFileId(Long processedFileId) {
        this.processedFileId = processedFileId;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public ValidationStatisticsDTO getStatistics() {
        return statistics;
    }

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
