package com.mercadinho.mercadinho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadinho.mercadinho.converts.ProdutoConvert;
import com.mercadinho.mercadinho.dtos.outputs.ProdutoOutput;
import com.mercadinho.mercadinho.entities.ProdutoEntity;
import com.mercadinho.mercadinho.services.ProdutoService;

@RestController
@RequestMapping("/produtos")

public class ProdutosController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoConvert produtoConvert;
	
	@GetMapping("/listaTodos")
	public List<ProdutoOutput> listaProdutos() {
		List<ProdutoEntity> produtosEncontrados = produtoService.buscaTodosProdutos();
		List<ProdutoOutput> produtoDeSaida = produtoConvert.listEntityToListOutput(produtosEncontrados);
		return produtoDeSaida;

	}

}
