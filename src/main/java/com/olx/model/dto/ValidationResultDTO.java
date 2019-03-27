package com.olx.model.dto;

import com.olx.model.FixedNumber;
import com.olx.model.InvalidNumber;
import com.olx.model.ValidNumber;

import java.util.List;

public class ValidationResultDTO {

    List<ValidNumber> validNumbers;

    List<FixedNumber> fixedNumbers;

    List<InvalidNumber> invalidNumbers;

    ValidationStatisticsDTO statistics;

    public List<ValidNumber> getValidNumbers() {
        return validNumbers;
    }

    public void setValidNumbers(List<ValidNumber> validNumbers) {
        this.validNumbers = validNumbers;
    }

    public List<FixedNumber> getFixedNumbers() {
        return fixedNumbers;
    }

    public void setFixedNumbers(List<FixedNumber> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    public List<InvalidNumber> getInvalidNumbers() {
        return invalidNumbers;
    }

    public void setInvalidNumbers(List<InvalidNumber> invalidNumbers) {
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
