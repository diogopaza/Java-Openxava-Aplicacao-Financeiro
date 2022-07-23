package com.yourcompany.invoicing.validators;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.yourcompany.invoicing.model.*;

public class OrderRemoveValidator implements IRemoveValidator {
	private Order order;

	public void setEntity(Object entity) {
		this.order = (Order) entity;
	}

	@Override
	public void validate(Messages errors) throws Exception {

		if (order.getInvoice() != null) {
			errors.add("cannot_delete_order_with_invoice");
		}

	}
}
