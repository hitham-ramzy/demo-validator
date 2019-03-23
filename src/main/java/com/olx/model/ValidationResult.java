package com.olx.model;

import com.olx.utils.ValidationStatus;

public class ValidationResult {
    private ValidationStatus status;
    private String description;
    private String fixedNumber;

    public ValidationResult(ValidationStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(String fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "status=" + status +
                ", description='" + description + '\'' +
                ", fixedNumber='" + fixedNumber + '\'' +
                '}';
    }
}
