package com.yourcompany.invoicing.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@View(extendsView = "super.DEFAULT", members = "estimatedDeliveryDays, delivered, invoice {invoice}")
@View(name = "NoCustomerNoInvoice", members = "year,number,date;" + "details;" + "remarks")

@Entity
@Getter
@Setter
@EntityValidator(
		value=com.yourcompany.invoicing.validators.DeliveredToBeInInvoiceValidator.class,
		properties= {
				@PropertyValue(name="year"),
				@PropertyValue(name="number"),
				@PropertyValue(name="invoice"),
				@PropertyValue(name="delivered")
		}
		)
public class Order extends CommercialDocument {
	
	@Depends("date")
	public int getEstimatedDeliveryDays() {
		if(getDate().getDayOfYear() < 15) {
			return 20 - getDate().getDayOfYear();
		}
		if(getDate().getDayOfWeek() == DayOfWeek.SUNDAY) return 2;
		if(getDate().getDayOfWeek() == DayOfWeek.SATURDAY) return 3;
		return 1;
	}
	
	@PrePersist @PreUpdate
	private void recalculateDeliveryDays() {
		setDeliveryDays(getEstimatedDeliveryDays());
	}
	
	@Column(columnDefinition="INTEGER DEFAULT 1")
	int deliveryDays;
	
	@ManyToOne
	@ReferenceView("NoCustomerNoOrders")
	private Invoice invoice;
	
	@Column(columnDefinition="BOOLEAN DEFAULT FALSE")
	boolean delivered;

}
