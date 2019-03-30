package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Mobile number.
 */
@Entity(name = "mobile_number")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "status", discriminatorType = DiscriminatorType.STRING)
public class MobileNumber extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 2281025270410523170L;

    @Id
    @Column(name = "mobile_id")
    private Long mobileId;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "status", nullable = false, insertable = false, updatable = false)
    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processed_file_id", nullable = false)
    private ProcessedFile processedFile;

    /**
     * Gets mobileId.
     *
     * @return the mobileId
     */
    public Long getMobileId() {
        return mobileId;
    }

    /**
     * Sets mobileId.
     *
     * @param mobileId the mobileId
     */
    public void setMobileId(Long mobileId) {
        this.mobileId = mobileId;
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

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    /**
     * Gets processed file.
     *
     * @return the processed file
     */
    public ProcessedFile getProcessedFile() {
        return processedFile;
    }

    /**
     * Sets processed file.
     *
     * @param processedFile the processed file
     */
    public void setProcessedFile(ProcessedFile processedFile) {
        this.processedFile = processedFile;
    }

    @Override
    public String toString() {
        return "ValidNumber{" +
                "mobileId=" + mobileId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
