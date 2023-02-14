package com.devmocroski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmocroski.backend.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
