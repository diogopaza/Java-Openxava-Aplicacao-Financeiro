package com.yourcompany.invoicing.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.yourcompany.invoicing.calculators.*;

import lombok.*;

@Embeddable @Getter @Setter // a anotação Embeddable quer dizer que a classe está habilitada a compor um enteidade por exemplo
							// os campos dessa tabela vao ficar gravados junto a entidade Invoice quando gravados no banco de dados.

public class Detail {
	int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Product product;
	
	@DefaultValueCalculator(
			value = PricePerUnitCalculator.class,
			properties = @PropertyValue(
					name="productNumber",
					from="product.number"
					)
			)
	
	@Stereotype("MONEY")
	BigDecimal pricePerUnit;
	
	@Stereotype("MONEY")
	@Depends("product.number, quantity")
	public BigDecimal getAmount() {
		if(pricePerUnit == null) return BigDecimal.ZERO;
		return new BigDecimal(quantity).multiply(pricePerUnit);
	}
	
	

}
