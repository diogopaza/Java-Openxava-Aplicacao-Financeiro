package com.yourcompany.invoicing.calculators;

import org.openxava.calculators.*;

import com.yourcompany.invoicing.util.*;

public class VatPercentageCalculator implements ICalculator{
	@Override
	public Object calculate() throws Exception {		
		return InvoicingPreferences.getDefaultVatPercentage();
	}
}
