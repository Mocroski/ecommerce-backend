package com.devmocroski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmocroski.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
