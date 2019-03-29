package com.olx.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "mobile_number")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "status", discriminatorType = DiscriminatorType.STRING)
public class MobileNumber implements Serializable {

    private static final long serialVersionUID = 2281025270410523170L;

    @Id
    private Long id;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

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
        return "ValidNumber{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
