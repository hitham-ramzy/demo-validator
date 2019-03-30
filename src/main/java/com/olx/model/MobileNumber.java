package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "status", nullable = false, insertable = false, updatable = false)
    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processed_file_id", nullable = false)
    private ProcessedFile processedFile;

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

    public String getStatus() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    public ProcessedFile getProcessedFile() {
        return processedFile;
    }

    public void setProcessedFile(ProcessedFile processedFile) {
        this.processedFile = processedFile;
    }

    @Override
    public String toString() {
        return "ValidNumber{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
