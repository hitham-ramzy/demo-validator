package com.olx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * The type Processed file.
 */
@Entity(name = "processed_file")
public class ProcessedFile extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 3849722357324512899L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "time", nullable = false)
    private ZonedDateTime time = ZonedDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "processedFile")
    private List<MobileNumber> mobileNumbers;

    @Column(name = "valid")
    private Integer valid;

    @Column(name = "fixed")
    private Integer fixed;

    @Column(name = "invalid")
    private Integer invalid;

    @Column(name = "created")
    private Integer created;

    @Column(name = "updated")
    private Integer updated;

    /**
     * Gets fileId.
     *
     * @return the fileId
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * Sets fileId.
     *
     * @param fileId the fileId
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets file name.
     *
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public ZonedDateTime getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    /**
     * Gets mobile numbers.
     *
     * @return the mobile numbers
     */
    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    /**
     * Sets mobile numbers.
     *
     * @param mobileNumbers the mobile numbers
     */
    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getFixed() {
        return fixed;
    }

    public void setFixed(Integer fixed) {
        this.fixed = fixed;
    }

    public Integer getInvalid() {
        return invalid;
    }

    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ProcessedFile{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", time=" + time +
                ", mobileNumbers=" + mobileNumbers +
                ", valid=" + valid +
                ", fixed=" + fixed +
                ", invalid=" + invalid +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
