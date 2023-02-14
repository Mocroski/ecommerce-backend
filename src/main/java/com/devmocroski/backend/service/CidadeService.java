package com.devmocroski.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.devmocroski.backend.entity.Cidade;
import com.devmocroski.backend.repository.CidadeRepository;

public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> buscarTodos(){
		return cidadeRepository.findAll();
	}
	
	public Cidade inserir(Cidade cidade) {
		cidade.setDataCriacao(new Date());
		Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
		return cidadeNovo;
	}
	
	public Cidade alterar(Cidade cidade) {
		cidade.setDataAtualizacao(new Date());
		return cidadeRepository.saveAndFlush(cidade);
	}
	
	public void excluir(Long id) {
		Cidade cidade = cidadeRepository.findById(id).get();
		cidadeRepository.delete(cidade);
	}

}
