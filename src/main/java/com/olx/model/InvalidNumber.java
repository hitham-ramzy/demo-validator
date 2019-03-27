package com.olx.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("INVALID")
public class InvalidNumber extends MobileNumber {

    private static final long serialVersionUID = 878606859544343247L;

    @Column(name = "why_failed", nullable = false)
    private String whyFailed;

    public String getWhyFailed() {
        return whyFailed;
    }

    public void setWhyFailed(String whyFailed) {
        this.whyFailed = whyFailed;
    }

    @Override
    public String toString() {
        return "InvalidNumber{" +
                ", whyFailed='" + whyFailed + '\'' +
                '}';
    }
}
