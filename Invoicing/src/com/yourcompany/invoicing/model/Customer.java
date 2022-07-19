package com.yourcompany.invoicing.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@View(name = "Simple", members = "number, name")
@Entity // diz que a classe é uma entidade
@Getter
@Setter // torna público todos os atributos
public class Customer {
	@Id
	@Column(length = 6)
	int number;

	@Column(length = 50)
	@Required // campo obrigatório não pode ficar vazio
	String name;

}
