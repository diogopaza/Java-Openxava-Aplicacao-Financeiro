package com.yourcompany.invoicing.model;

import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.yourcompany.invoicing.calculators.*;

import lombok.*;

//@View(members = "year, number, date;" + "customer;" + "details;" + "remarks")
@View(members = "year, number, date," + "data {" + "customer;" + "details;" + "remarks" + "}")
@Entity
@Getter
@Setter
abstract public class CommercialDocument extends Identifiable {

	@PrePersist
	private void calculateNumber() throws Exception {
		Query query = XPersistence.getManager()
				.createQuery("select max(i.number) from " + getClass().getSimpleName() + " i where i.year = :year");
		query.setParameter("year", year);
		Integer lastNumber = (Integer) query.getSingleResult();
		this.number = lastNumber == null ? 1 : lastNumber + 1;

	}

	@Column(length = 4)
	@DefaultValueCalculator(CurrentYearCalculator.class) // traz o ano atual já inserido para o usuário
	int year;

	@Column(length = 6)
	//@DefaultValueCalculator(value = NextNumberForYearCalculator.class, properties = @PropertyValue(name = "year"))
	@ReadOnly
	int number;

	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) // traz a data atual para o usuário
	LocalDate date;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	Customer customer;

	/*
	 * @ElementCollection
	 * 
	 * @ListProperties("product.number, product.description, quantity, pricePerUnit, "
	 * + "valorTotal+[" + "commercialDocument.vatPercentage," +
	 * "commercialDocument.vat," + "commercialDocument.totalAmount" + "]" )
	 * 
	 * @ElementCollection
	 * 
	 * @ListProperties("product.number, product.description, quantity, pricePerUnit, amount+["
	 * + "commercialDocument.vatPercentage," + "commercialDocument.vat," +
	 * "commercialDocument.totalAmount" + "]") Collection<Detail> details;
	 */

	@ElementCollection
	@ListProperties("product.number, product.description, quantity, pricePerUnit, "
			+ "amount+[commercialDocument.vatPercentage, commercialDocument.vat, commercialDocument.totalAmount ]")
	private Collection<Detail> details;
	/*
	 * @Digits(integer = 2, fraction = 0) BigDecimal vatPercentage;
	 * 
	 * @ReadOnly
	 * 
	 * @Stereotype("MONEY")
	 * 
	 * @Calculation("sum(details.amount) * vatPercentage / 100") BigDecimal vat;
	 * 
	 * @ReadOnly
	 * 
	 * @Stereotype("MONEY")
	 * 
	 * @Calculation("sum(details.amount) + vat") BigDecimal totalAmount;
	 */

	@DefaultValueCalculator(VatPercentageCalculator.class)
	@Digits(integer = 2, fraction = 0) // To indicate its size
	BigDecimal vatPercentage;

	@ReadOnly
	@Stereotype("MONEY")
	@Calculation("sum(details.amount) * vatPercentage / 100")
	BigDecimal vat;

	@ReadOnly
	@Stereotype("MONEY")
	@Calculation("sum(details.amount) + vat")
	BigDecimal totalAmount;	
	

	@org.hibernate.annotations.Formula("TOTALAMOUNT * 0.10")
	@Setter(AccessLevel.NONE)
	@Stereotype("MONEY")
	BigDecimal estimatedProfit;
	
	@Stereotype("MEMO")
	String remarks;
	

}
