package com.olx.model;

public class MobileNumberInput {

    Long id;
    String mobileNumber;

    public MobileNumberInput(Long id, String mobileNumber) {
        this.id = id;
        this.mobileNumber = mobileNumber;
    }

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

    @Override
    public String toString() {
        return "MobileNumberInput{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
