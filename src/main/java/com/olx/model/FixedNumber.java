package com.olx.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Fixed number.
 */
@Entity
@DiscriminatorValue("FIXED")
public class FixedNumber extends MobileNumber {

    private static final long serialVersionUID = -5694421262629992465L;

    @Column(name = "what_was_modified", nullable = false)
    private String whatWasModified;

    /**
     * Gets what was modified.
     *
     * @return the what was modified
     */
    public String getWhatWasModified() {
        return whatWasModified;
    }

    /**
     * Sets what was modified.
     *
     * @param whatWasModified the what was modified
     */
    public void setWhatWasModified(String whatWasModified) {
        this.whatWasModified = whatWasModified;
    }

    @Override
    public String toString() {
        return "FixedNumber{" +
                ", whatWasModified='" + whatWasModified + '\'' +
                '}';
    }

}
