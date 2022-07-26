# Java-Openxava-Aplicacao-Financeiro

Classes abstratas ===

Anotação @MappedSuperclass ===

@Calculation é uma anotação OpenXava que permite associar um cálculo simples a uma propriedade persistente.

Princípio pragmático === não use o nome da classe em nome de mebros. Ex: na classe conta, não declare o método cancelarConta() e sim apenas cancelar().

<strong>Biblioteca Lombok</strong> defini os métodos Getters e Setters em Java. ex: @Getter @Setter geram o getter e o setter no código compilado.

<strong>JAX-RS</strong> é o padrão Java para chamar serviços web REST.

O <strong>Commons Validator</strong> contém algoritmos de validação para endereços de e-mail, datas, URLs e assim por diante. O validador de commons.jar está incluído por padrão em projetos OpenXava. Exemplo de utilização: package com.yourcompany.invoicing.validators.ISBNValidator essa classe é usada junto com a anotação <em>Bean</em> disponível em com.yourcompany.invoicing.annotations.ISBN. Esse validador é uma anotação criada manualmente no projeto.

<h3>Lista de Restrições Integradas da Validação de Bean.</h3>
<p>Uso de restrições integradas de validação de bean.</p>
Restrição Uso:<br/>
@Null	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor nulo. Essa restrição aceita qualquer tipo.
@NotNull	Especifica se a propriedade de configuração decorada com essa anotação não deve ter um valor nulo. Ou seja, a propriedade é necessária. Essa restrição aceita qualquer tipo.
@AssertTrue	Especifica se a propriedade de configuração decorada com essa anotação deve ser true. Os tipos de valores suportados são booleano e Booleano. Elementos nulos são considerados válidos.
@AssertFalse	Especifica se a propriedade de configuração decorada com essa anotação deve ser false. Os tipos de valores suportados são booleano e Booleano. Elementos nulos são considerados válidos.
@Min	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor maior ou igual ao mínimo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@Max	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor menor ou igual ao máximo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@DecimalMin	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor maior ou igual ao mínimo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, String, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@DecimalMax	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor menor ou igual ao máximo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, String, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@Size	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor entre os limites especificados (incluídos). Os tipos de valores suportados são Sequência (o comprimento da sequência é avaliado), Coleção (o tamanho da coleção é avaliado), Mapa (o tamanho do mapa é avaliado), Matriz (o comprimento da matriz é avaliado). Elementos nulos são considerados válidos.
@DecimalMin	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor maior ou igual ao mínimo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, String, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@DecimalMax	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor menor ou igual ao máximo especificado. Os tipos de valores suportados são BigDecimal, BigInteger, String, byte, short, int, long e seus respectivos wrappers. Elementos nulos são considerados válidos.
@Size	Especifica se a propriedade de configuração decorada com essa anotação deve ter um valor entre os limites especificados (incluídos). Os tipos de valores suportados são Sequência (o comprimento da sequência é avaliado), Coleção (o tamanho da coleção é avaliado), Mapa (o tamanho do mapa é avaliado), Matriz (o comprimento da matriz é avaliado). Elementos nulos são considerados válidos.
@Pattern	Especifica se a propriedade de configuração decorada com essa anotação deve corresponder à expressão regular a seguir. A expressão regular segue o java.util.regex.Pattern das convenções da expressão regular Java™. O valor de tipo suportado é Sequência. Elementos nulos são considerados válidos.
