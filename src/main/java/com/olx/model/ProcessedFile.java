package com.olx.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * The type Processed file.
 */
@Entity(name = "processed_file")
public class ProcessedFile implements Serializable {

    private static final long serialVersionUID = 3849722357324512899L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "time", nullable = false)
    private ZonedDateTime time = ZonedDateTime.now();

    @OneToMany(mappedBy = "processedFile")
    private List<MobileNumber> mobileNumbers;

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

    @Override
    public String toString() {
        return "ProcessedFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", time=" + time +
                '}';
    }
}
