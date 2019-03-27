package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "invalid_number")
public class InvalidNumber implements Serializable {

    private static final long serialVersionUID = 878606859544343247L;

    @Id
    private Long id;

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
                ", whyFailed='" + whyFailed + '\'' +
                ", uploadAction=" + uploadAction +
                '}';
    }
}
