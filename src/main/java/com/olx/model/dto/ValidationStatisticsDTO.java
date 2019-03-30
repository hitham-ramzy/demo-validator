package com.olx.model.dto;

/**
 * The type Validation statistics dto.
 */
public class ValidationStatisticsDTO {

    private Integer valid;

    private Integer fixed;

    private Integer invalid;

    private Integer created;

    private Integer updated;

    /**
     * Gets valid.
     *
     * @return the valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * Sets valid.
     *
     * @param valid the valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * Gets fixed.
     *
     * @return the fixed
     */
    public Integer getFixed() {
        return fixed;
    }

    /**
     * Sets fixed.
     *
     * @param fixed the fixed
     */
    public void setFixed(Integer fixed) {
        this.fixed = fixed;
    }

    /**
     * Gets invalid.
     *
     * @return the invalid
     */
    public Integer getInvalid() {
        return invalid;
    }

    /**
     * Sets invalid.
     *
     * @param invalid the invalid
     */
    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public Integer getCreated() {
        return created;
    }

    /**
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

    /**
     * Gets updated.
     *
     * @return the updated
     */
    public Integer getUpdated() {
        return updated;
    }

    /**
     * Sets updated.
     *
     * @param updated the updated
     */
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
