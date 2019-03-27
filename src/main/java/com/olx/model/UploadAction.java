package com.olx.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "upload_action")
public class UploadAction implements Serializable {

    private static final long serialVersionUID = 7783109257778943213L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime time = ZonedDateTime.now();

    @OneToMany(mappedBy = "uploadAction")
    private List<ValidNumber> validNumbers;

    @OneToMany(mappedBy = "uploadAction")
    private List<FixedNumber> fixedNumbers;

    @OneToMany(mappedBy = "uploadAction")
    private List<InvalidNumber> invalidNumbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public List<ValidNumber> getValidNumbers() {
        return validNumbers;
    }

    public void setValidNumbers(List<ValidNumber> validNumbers) {
        this.validNumbers = validNumbers;
    }

    public List<FixedNumber> getFixedNumbers() {
        return fixedNumbers;
    }

    public void setFixedNumbers(List<FixedNumber> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    public List<InvalidNumber> getInvalidNumbers() {
        return invalidNumbers;
    }

    public void setInvalidNumbers(List<InvalidNumber> invalidNumbers) {
        this.invalidNumbers = invalidNumbers;
    }

    @Override
    public String toString() {
        return "UploadAction{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
