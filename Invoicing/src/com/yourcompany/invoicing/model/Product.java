package com.yourcompany.invoicing.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Product {
	
	@Id @Column(length=9)
	int number;
	
	@Column(length=50) @Required
	String description;
	
	@Column(precision =10, scale=2, nullable=true)
	BigDecimal price;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	Author author;
	
}
