package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "fixed_number")
public class FixedNumber implements Serializable {

    private static final long serialVersionUID = -5694421262629992465L;

    @Id
    private Long id;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "what_was_modified")
    private String whatWasModified;

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

    public String getWhatWasModified() {
        return whatWasModified;
    }

    public void setWhatWasModified(String whatWasModified) {
        this.whatWasModified = whatWasModified;
    }

    public UploadAction getUploadAction() {
        return uploadAction;
    }

    public void setUploadAction(UploadAction uploadAction) {
        this.uploadAction = uploadAction;
    }

    @Override
    public String toString() {
        return "FixedNumber{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", whatWasModified='" + whatWasModified + '\'' +
                ", uploadAction=" + uploadAction +
                '}';
    }

}
