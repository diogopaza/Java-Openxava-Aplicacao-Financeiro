package com.yourcompany.invoicing.calculators;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.yourcompany.invoicing.model.*;

import lombok.*;

public class PricePerUnitCalculator implements ICalculator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	int productNumber;
	
	public Object calculate() throws Exception{
		Product product = getManager()
				.find(Product.class, productNumber);		
		return product.getPrice();
		
	}

}
