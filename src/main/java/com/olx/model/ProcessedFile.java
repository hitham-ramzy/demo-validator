package com.olx.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

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
