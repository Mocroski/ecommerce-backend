package com.devmocroski.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entity.Permissao;
import com.devmocroski.backend.entity.PermissaoPessoa;
import com.devmocroski.backend.entity.Pessoa;
import com.devmocroski.backend.repository.PermissaoPessoaRepository;
import com.devmocroski.backend.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {

	@Autowired
	private PermissaoPessoaRepository permissaoPessoaRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
		List<Permissao> listaPermissao = permissaoRepository.findByNome(nome: "cliente");
		if(listaPermissao.size()>0) {
			PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
			permissaoPessoa.setPessoa(pessoa);
			permissaoPessoa.setPermissao(listaPermissao.get(index:0));
			permissaoPessoa.setDataCriacao(new Date());
			permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
		}
	}
}
