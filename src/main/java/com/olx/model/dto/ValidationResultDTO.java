package com.olx.model.dto;

import com.olx.model.MobileNumber;
import com.olx.model.MobileNumber;
import com.olx.model.MobileNumber;

import java.util.ArrayList;
import java.util.List;

public class ValidationResultDTO {

    private Long processedFileId;

    private List<MobileNumber> validNumbers = new ArrayList<>();

    private List<MobileNumber> fixedNumbers = new ArrayList<>();

    private List<MobileNumber> invalidNumbers = new ArrayList<>();

    ValidationStatisticsDTO statistics;

    public Long getProcessedFileId() {
        return processedFileId;
    }

    public void setProcessedFileId(Long processedFileId) {
        this.processedFileId = processedFileId;
    }

    public List<MobileNumber> getValidNumbers() {
        return validNumbers;
    }

    public void setValidNumbers(List<MobileNumber> validNumbers) {
        this.validNumbers = validNumbers;
    }

    public List<MobileNumber> getFixedNumbers() {
        return fixedNumbers;
    }

    public void setFixedNumbers(List<MobileNumber> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    public List<MobileNumber> getInvalidNumbers() {
        return invalidNumbers;
    }

    public void setInvalidNumbers(List<MobileNumber> invalidNumbers) {
        this.invalidNumbers = invalidNumbers;
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
                "validNumbers=" + validNumbers +
                ", fixedNumbers=" + fixedNumbers +
                ", invalidNumbers=" + invalidNumbers +
                ", statistics=" + statistics +
                '}';
    }
}
