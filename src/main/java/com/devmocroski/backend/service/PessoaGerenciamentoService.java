package com.devmocroski.backend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entity.Pessoa;
import com.devmocroski.backend.repository.PessoaRepository;

@Service
public class PessoaGerenciamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EmailService emailService;
	
	public String solicitarCodigo(String email) {
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
		pessoa.setDataEnvioCodigo(new Date());
		pessoaRepository.saveAndFlush(pessoa);
		emailService.enviarEmailTexto(pessoa.getEmail(), "Codigo Recuperacao Senha", "Olá o seu codigo para recuperacao de senha é: "+pessoa.getCodigoRecuperacaoSenha());
		
		return "Codigo Enviado";
	}
	
	private String getCodigoRecuperacaoSenha(Long id) {
		DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
		return format.format(new Date()) + id;
		
	}
	
	
}
