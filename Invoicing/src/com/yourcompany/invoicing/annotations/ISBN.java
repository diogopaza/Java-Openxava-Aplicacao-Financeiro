package com.yourcompany.invoicing.annotations;

import java.lang.annotation.*;

import javax.validation.*;

@Constraint(validatedBy = com.yourcompany.invoicing.validators.ISBNValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ISBN {
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "isbn_invalid";
}