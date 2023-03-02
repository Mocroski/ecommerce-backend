package com.devmocroski.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devmocroski.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
	
	@Autowired
	private PessoaGerenciamentoService pesssoaGerenciamentoService;
	
	@PostMapping("/")
	public String recuperarCodigo(@RequestParam("email") String email) {
		
		return pesssoaGerenciamentoService.solicitarCodigo(email);
	}
}
