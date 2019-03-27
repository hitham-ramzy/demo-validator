package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "valid_number")
public class ValidNumber implements Serializable {

    private static final long serialVersionUID = 2281025270410523170L;

    @Id
    private Long id;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

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

    public UploadAction getUploadAction() {
        return uploadAction;
    }

    public void setUploadAction(UploadAction uploadAction) {
        this.uploadAction = uploadAction;
    }

    @Override
    public String toString() {
        return "ValidNumber{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", uploadAction=" + uploadAction +
                '}';
    }
}
