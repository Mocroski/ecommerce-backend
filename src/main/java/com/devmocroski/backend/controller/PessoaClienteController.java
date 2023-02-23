package com.devmocroski.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmocroski.backend.dto.PessoaClienteRequestDTO;
import com.devmocroski.backend.entity.Pessoa;
import com.devmocroski.backend.service.PessoaClienteService;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

	@Autowired
	private PessoaClienteService pessoaService;
	
	@PostMapping("/")
	public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		
		return pessoaService.registrar(pessoaClienteRequestDTO);
	}
}
 