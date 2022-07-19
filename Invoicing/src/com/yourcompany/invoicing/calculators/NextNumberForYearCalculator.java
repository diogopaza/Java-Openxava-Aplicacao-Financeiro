package com.yourcompany.invoicing.calculators;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;


public class NextNumberForYearCalculator implements ICalculator{	
	
	@Getter @Setter
	int year;
	
	public Object calculate() throws Exception{
		
		Query query = XPersistence.getManager()
				.createQuery("select max(i.number) from Invoice i where i.year = :year"); 
		query.setParameter("year", year);
		Integer lastNumber = (Integer) query.getSingleResult();
		return lastNumber == null ? 1 : lastNumber + 1;
	}
}
