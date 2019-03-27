package com.olx.model;

public class ValidationResult {
    private ValidationStatus status;
    private String fixedNumber;
    private String description;

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public String getFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(String fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "status=" + status +
                "fixedNumber=" + fixedNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
