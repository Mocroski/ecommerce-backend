package com.devmocroski.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entity.Produto;
import com.devmocroski.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	public Produto inserir(Produto objeto) {
		objeto.setDataCriacao(new Date());
		Produto objetoNovo = produtoRepository.saveAndFlush(objeto);
		return objetoNovo;
	}

	public Produto alterar(Produto objeto) {
		objeto.setDataAtualizacao(new Date());
		return produtoRepository.saveAndFlush(objeto);
	}

	public void excluir(Long id) {
		Produto objeto = produtoRepository.findById(id).get();
		produtoRepository.delete(objeto);
	}
}


