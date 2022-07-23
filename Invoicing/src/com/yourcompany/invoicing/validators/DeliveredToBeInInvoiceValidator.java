package com.yourcompany.invoicing.validators;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.yourcompany.invoicing.model.*;

import lombok.*;

@Getter @Setter
public class DeliveredToBeInInvoiceValidator implements IValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int year;
	int number;
	boolean delivered;
	Invoice invoice;

	@Override
	public void validate(Messages errors) throws Exception {
		{
			System.out.println("validando");
			if (invoice == null) return;
			if (!delivered) {
				errors.add("order_must_be_delivered", year, number);

			}
		}

	}

}
