package com.devmocroski.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.dto.PessoaClienteRequestDTO;
import com.devmocroski.backend.entity.Pessoa;
import com.devmocroski.backend.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {
	
	@Autowired
	private PessoaClienteRepository pessoaClienteRepository;
	
	@Autowired
	private PermissaoPessoaService permissaoPessoaService;
	
	@Autowired
	private EmailService emailService;
	
	public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
		pessoa.setDataCriacao(new Date());
		Pessoa objetoNovo = pessoaClienteRepository.saveAndFlush(pessoa);
		permissaoPessoaService.vincularPessoaPermissaoCliente(objetoNovo);
		emailService.enviarEmailTexto(objetoNovo.getEmail(), "Cadastro E-commerce teste", "Cadastro realizado com sucesso bem vindo" + objetoNovo.getNome());
		return objetoNovo;
	}
	
	
}
