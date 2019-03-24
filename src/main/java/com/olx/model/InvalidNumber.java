package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "invalid_number")
public class InvalidNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_id", nullable = false)
    private Long sourceId;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "why_failed", nullable = false)
    private String whyFailed;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upload_action_id")
    private UploadAction uploadAction;

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

    public String getWhyFailed() {
        return whyFailed;
    }

    public void setWhyFailed(String whyFailed) {
        this.whyFailed = whyFailed;
    }

    public UploadAction getUploadAction() {
        return uploadAction;
    }

    public void setUploadAction(UploadAction uploadAction) {
        this.uploadAction = uploadAction;
    }

    @Override
    public String toString() {
        return "InvalidNumber{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", whyFailed='" + whyFailed + '\'' +
                ", uploadAction=" + uploadAction +
                '}';
    }
}
