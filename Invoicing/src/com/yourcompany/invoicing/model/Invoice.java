package com.yourcompany.invoicing.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
/*
@View(members = "year, number, date;" +
		"data {" + 
		"customer;" + 
		"details;" + 
		"remarks" +
		"}" + 
		"orders { orders }"		
	)*/
@View(extendsView="super.DEFAULT",
		members="orders {orders}"
)
@View(name="NoCustomerNoOrders",
		members= 
		"year, number, date;" +
		"details;" +
		"remarks"
		)
public class Invoice extends CommercialDocument {
	@OneToMany(mappedBy = "invoice")
	@CollectionView("NoCustomerNoInvoice")
	Collection<Order> orders;
}
