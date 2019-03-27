package com.olx.model.dto;

import com.olx.model.MobileNumber;
import com.olx.model.MobileNumber;
import com.olx.model.MobileNumber;

import java.util.List;

public class ValidationResultDTO {

    List<MobileNumber> validNumbers;

    List<MobileNumber> fixedNumbers;

    List<MobileNumber> invalidNumbers;

    ValidationStatisticsDTO statistics;

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
                "validNumbers=" + validNumbers +
                ", fixedNumbers=" + fixedNumbers +
                ", invalidNumbers=" + invalidNumbers +
                ", statistics=" + statistics +
                '}';
    }
}
