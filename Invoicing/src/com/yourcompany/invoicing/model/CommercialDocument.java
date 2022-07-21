package com.yourcompany.invoicing.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.yourcompany.invoicing.calculators.*;

import lombok.*;

//@View(members = "year, number, date;" + "customer;" + "details;" + "remarks")
@View(members = "year, number, date," + "data {" + "customer;" + "details;" + "remarks" + "}")
@Entity
@Getter
@Setter
abstract public class CommercialDocument extends Identifiable {

	@Column(length = 4)
	@DefaultValueCalculator(CurrentYearCalculator.class) // traz o ano atual j� inserido para o usu�rio
	int year;

	@Column(length = 6)
	@DefaultValueCalculator(value = NextNumberForYearCalculator.class, properties = @PropertyValue(name = "year"))
	int number;

	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) // traz a data atual para o usu�rio
	LocalDate date;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	Customer customer;
	

	@ElementCollection
	@ListProperties("product.number, product.description, quantity, pricePerUnit, valorTotal")
	Collection<Detail> details;

	@Stereotype("MEMO")
	String remarks;

}
