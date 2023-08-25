package com.mercadinho.mercadinho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadinho.mercadinho.entities.ProdutoEntity;

@Repository

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
