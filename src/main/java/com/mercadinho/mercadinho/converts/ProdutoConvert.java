package com.mercadinho.mercadinho.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadinho.mercadinho.dtos.outputs.ProdutoOutput;
import com.mercadinho.mercadinho.entities.ProdutoEntity;

@Component
public class ProdutoConvert {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoOutput EntityToOutput(ProdutoEntity produtoEntity) {
		return modelMapper.map(produtoEntity, ProdutoOutput.class);
	}

	public List<ProdutoOutput> listEntityToListOutput(List<ProdutoEntity> produtosEncontrados) {
		return produtosEncontrados.stream().map(a -> this.EntityToOutput(a)).collect(Collectors.toList());
	}
}
