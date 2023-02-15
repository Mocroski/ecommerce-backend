package com.devmocroski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmocroski.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
