package com.mercadinho.mercadinho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadinho.mercadinho.converts.ProdutoConvert;
import com.mercadinho.mercadinho.dtos.inputs.ProdutoInput;
import com.mercadinho.mercadinho.dtos.outputs.ProdutoOutput;
import com.mercadinho.mercadinho.entities.ProdutoEntity;
import com.mercadinho.mercadinho.services.ProdutoService;

import jakarta.validation.Valid;

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

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/cadastro")
	public ProdutoOutput cadastrarProdutos(@Valid @RequestBody ProdutoInput produtoInput) {
		ProdutoEntity produtoConvertidoParaEntity = produtoConvert.InputToEntity(produtoInput);

		ProdutoEntity produtoCadastrado = produtoService.cadastrarProduto(produtoConvertidoParaEntity);

		ProdutoOutput produtoConvertidoParaOutput = produtoConvert.EntityToOutput(produtoCadastrado);

		return produtoConvertidoParaOutput;
	}
	
	
	@GetMapping("/{id}")
	public ProdutoOutput buscaProdutoPorId(@PathVariable Long id) {
	ProdutoEntity produtoEncontrado = produtoService.buscaProdutoPorId(id);
		
	ProdutoOutput produtoConvertidoParaOutput = produtoConvert.EntityToOutput(produtoEncontrado);
		
	return produtoConvertidoParaOutput;
	}
	
}


