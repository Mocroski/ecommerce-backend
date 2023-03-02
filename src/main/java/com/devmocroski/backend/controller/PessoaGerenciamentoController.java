package com.devmocroski.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devmocroski.backend.entity.Pessoa;
import com.devmocroski.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
	
	@Autowired
	private PessoaGerenciamentoService pesssoaGerenciamentoService;
	
	@PostMapping("/senha-codigo")
	public String recuperarCodigo(@RequestBody Pessoa pessoa) {
		
		return pesssoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
	}
	
	@PostMapping("/senha-alterar")
	public String alterarSenha(@RequestBody Pessoa pessoa) {
		
		return pesssoaGerenciamentoService.alterarSenha(pessoa);
	}
}
