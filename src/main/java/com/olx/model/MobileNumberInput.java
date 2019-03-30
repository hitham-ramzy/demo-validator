package com.olx.model;

/**
 * The type Mobile number input.
 */
public class MobileNumberInput {

    /**
     * The Id.
     */
    Long id;
    /**
     * The Mobile number.
     */
    String mobileNumber;

    /**
     * Instantiates a new Mobile number input.
     *
     * @param id           the id
     * @param mobileNumber the mobile number
     */
    public MobileNumberInput(Long id, String mobileNumber) {
        this.id = id;
        this.mobileNumber = mobileNumber;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets mobile number.
     *
     * @return the mobile number
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Sets mobile number.
     *
     * @param mobileNumber the mobile number
     */
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
