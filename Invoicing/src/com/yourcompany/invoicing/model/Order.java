package com.yourcompany.invoicing.model;

import javax.persistence.*;

@Entity
public class Order extends CommercialDocument {
	@ManyToOne
	Invoice invoice;
	
}
