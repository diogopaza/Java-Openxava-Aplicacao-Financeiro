package com.yourcompany.invoicing.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@View(extendsView = "super.DEFAULT", members = "invoice {invoice}")
@View(name = "NoCustomerNoInvoice", members = "year,number,date;" + "details;" + "remarks")

@Entity
@Getter
@Setter
public class Order extends CommercialDocument {
	@ManyToOne
	@ReferenceView("NoCustomerNoOrders")
	private Invoice invoice;

}
