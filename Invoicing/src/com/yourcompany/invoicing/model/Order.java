package com.yourcompany.invoicing.model;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

import lombok.*;

@View(extendsView = "super.DEFAULT", members = "estimatedDeliveryDays, delivered, invoice {invoice}")
@View(name = "NoCustomerNoInvoice", members = "year,number,date;" + "details;" + "remarks")

@Entity
@Getter
@Setter /*
		 * @EntityValidator(
		 * value=com.yourcompany.invoicing.validators.DeliveredToBeInInvoiceValidator.
		 * class, properties= {
		 * 
		 * @PropertyValue(name="year"),
		 * 
		 * @PropertyValue(name="number"),
		 * 
		 * @PropertyValue(name="invoice"),
		 * 
		 * @PropertyValue(name="delivered") } )
		 * 
		 */
//@RemoveValidator(com.yourcompany.invoicing.validators.OrderRemoveValidator.class)
public class Order extends CommercialDocument {

	@Depends("date")
	public int getEstimatedDeliveryDays() {
		if (getDate().getDayOfYear() < 15) {
			return 20 - getDate().getDayOfYear();
		}
		if (getDate().getDayOfWeek() == DayOfWeek.SUNDAY)
			return 2;
		if (getDate().getDayOfWeek() == DayOfWeek.SATURDAY)
			return 3;
		return 1;
	}

	@PrePersist
	@PreUpdate
	private void recalculateDeliveryDays() {
		setDeliveryDays(getEstimatedDeliveryDays());
	}
	/*
	 * public void setInvoice(Invoice invoice) { if (invoice != null &&
	 * !isDelivered()) { // The validation logic // The validation exception from
	 * Bean Validation throw new javax.validation.ValidationException(
	 * XavaResources.getString( "order_must_be_delivered", getYear(), getNumber() )
	 * ); } this.invoice = invoice; // The regular setter assignment }
	 */

	/*
	 * @PrePersist @PreUpdate private void validate() throws Exception{ if(invoice
	 * !=null && !isDelivered()) { throw new javax.validation.ValidationException(
	 * XavaResources.getString( "order_must_be_delivered", getYear(), getNumber() )
	 * ); } }
	 */
	
	 @AssertTrue( message="order_must_be_delivered" ) 
	 private boolean isDeliveredToBeInvoiced() { 
		 return invoice == null || isDelivered(); 
		 }
	 

	@PreRemove 
	private void validateOnRemove() {
		if(invoice != null) {
			throw new javax.validation.ValidationException(
				XavaResources.getString(
						"cannot_delete_order_with_invoice"));
		}
	}

	@Column(columnDefinition = "INTEGER DEFAULT 1")
	int deliveryDays;

	@ManyToOne
	@ReferenceView("NoCustomerNoOrders")
	private Invoice invoice;

	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
	boolean delivered;

}
