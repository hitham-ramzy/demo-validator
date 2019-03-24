package com.olx.model;

import javax.persistence.*;

@Entity(name = "validation_result")
public class ValidationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_id", nullable = false)
    private Long sourceId;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "status", nullable = false)
    private ValidationStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "fixed_mobile_number")
    private String fixedMobileNumber;


    public ValidationResult(ValidationStatus status) {
        this.status = status;
    }

    public ValidationResult() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public String getFixedMobileNumber() {
        return fixedMobileNumber;
    }

    public void setFixedMobileNumber(String fixedMobileNumber) {
        this.fixedMobileNumber = fixedMobileNumber;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", fixedMobileNumber='" + fixedMobileNumber + '\'' +
                '}';
    }
}
