package com.yourcompany.invoicing.validators;

import javax.validation.*;

import org.openxava.util.*;

import com.yourcompany.invoicing.annotations.*;

public class ISBNValidator implements ConstraintValidator<ISBN, Object> {

	private static org.apache.commons.validator.routines.ISBNValidator validator = 
			new org.apache.commons.validator.routines.ISBNValidator();

	public void initialize(ISBN isbn) {

	}

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (Is.empty(value))
			return true;
		return validator.isValid(value.toString());
	}
}
