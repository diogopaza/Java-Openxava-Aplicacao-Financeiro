package com.yourcompany.invoicing.model;

import javax.persistence.*;

import lombok.*;

@Embeddable @Getter @Setter // a anota��o Embeddable quer dizer que a classe est� habilitada a compor um enteidade por exemplo
							// os campos dessa tabela vao ficar gravados junto a entidade Invoice quando gravados no banco de dados.
public class Detail {
	int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Product product;

}
