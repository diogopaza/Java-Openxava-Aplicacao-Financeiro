package com.yourcompany.invoicing.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.yourcompany.invoicing.calculators.*;

import lombok.*;

@View(members = "year, number, date;" + "customer;" + "details;" + "remarks")
@Entity
@Getter
@Setter
public class Invoice {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	String oid;

	@Column(length = 4)
	@DefaultValueCalculator(CurrentYearCalculator.class) // traz o ano atual já inserido para o usuário
	int year;

	@Column(length = 6)
	@DefaultValueCalculator(value = NextNumberForYearCalculator.class, properties = @PropertyValue(name = "year"))
	int number;

	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) // traz a data atual para o usuário
	LocalDate date;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	Customer customer;

	@ElementCollection
	@ListProperties("product.number, product.description, quantity")
	Collection<Detail> details;

	@Stereotype("MEMO")
	String remarks;
	
	

}
