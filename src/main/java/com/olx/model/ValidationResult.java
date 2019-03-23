package com.olx.model;

public class ValidationResult {
    private Long sourceId;
    private String sourceMobileNumber;
    private ValidationStatus status;
    private String description;
    private String fixedNumber;

    public ValidationResult(ValidationStatus status) {
        this.status = status;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceMobileNumber() {
        return sourceMobileNumber;
    }

    public void setSourceMobileNumber(String sourceMobileNumber) {
        this.sourceMobileNumber = sourceMobileNumber;
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
                "sourceId=" + sourceId +
                ", sourceMobileNumber='" + sourceMobileNumber + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", fixedNumber='" + fixedNumber + '\'' +
                '}';
    }
}
