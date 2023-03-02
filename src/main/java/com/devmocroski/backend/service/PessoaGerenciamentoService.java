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
	
	public String alterarSenha(Pessoa pessoa) {
		
		Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
		
		if(pessoaBanco != null) {
		Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());
		
		if(diferenca.getTime()/1000<900) {
			//depois criptografar senha ocm spring security
			pessoaBanco.setSenha(pessoa.getSenha());
			pessoaBanco.setCodigoRecuperacaoSenha(null);
			pessoaRepository.saveAndFlush(pessoaBanco);
			return "senha Alterada com sucesso";
			
		}else {
			return "Tempo expirado solicite um novo coigo";
		}
	}else {
		return "Email ou codigo nao encontrado";
	}
	}
	private String getCodigoRecuperacaoSenha(Long id) {
		DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
		return format.format(new Date()) + id;
		
	}
	
	
}
