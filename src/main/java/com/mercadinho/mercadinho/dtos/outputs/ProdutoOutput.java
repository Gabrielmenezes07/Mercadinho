package com.mercadinho.mercadinho.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProdutoOutput {

	private Long id;

	private String nome;

	private Integer quantidade;

	private Double preco;
}
