package com.yourcompany.invoicing.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@View(name = "Simple", members = "number, name")
@Entity // diz que a classe � uma entidade
@Getter
@Setter // torna p�blico todos os atributos
public class Customer {
	@Id
	@Column(length = 6)
	int number;

	@Column(length = 50)
	@Required // campo obrigat�rio n�o pode ficar vazio
	String name;

}
