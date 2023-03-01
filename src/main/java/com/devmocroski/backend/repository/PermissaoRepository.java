package com.devmocroski.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devmocroski.backend.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	@Query
	List<Permissao> findByNome(String nome);
}
