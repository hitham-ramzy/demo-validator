package com.olx.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Valid number.
 */
@Entity
@DiscriminatorValue("VALID")
public class ValidNumber extends MobileNumber {

    private static final long serialVersionUID = 2281025270410523170L;

}
