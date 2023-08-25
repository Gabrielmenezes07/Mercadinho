package com.mercadinho.mercadinho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadinho.mercadinho.entities.ProdutoEntity;
import com.mercadinho.mercadinho.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoEntity> buscaTodosProdutos() {
		return produtoRepository.findAll();
	}

	@Transactional
	public ProdutoEntity cadastrarProduto(ProdutoEntity produtoConvertidoParaEntity) {
		return produtoRepository.save(produtoConvertidoParaEntity);
	}

	public ProdutoEntity buscaProdutoPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrado o produto pelo id: " + id));
	}

	@Transactional
	public void deletarProduto(ProdutoEntity produtoEncontrado) {
		produtoRepository.delete(produtoEncontrado);
	}

}
