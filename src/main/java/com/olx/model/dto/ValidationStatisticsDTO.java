package com.olx.model.dto;

public class ValidationStatisticsDTO {

    private Integer valid;

    private Integer fixed;

    private Integer invalid;

    private Integer created;

    private Integer updated;

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
        return "ValidationStatisticsDTO{" +
                "valid=" + valid +
                ", fixed=" + fixed +
                ", invalid=" + invalid +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
