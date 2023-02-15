package com.devmocroski.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmocroski.backend.entity.Permissao;
import com.devmocroski.backend.service.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoService permissaoService;
	
	@GetMapping("/")
	public List<Permissao> buscarTodos() {
		return permissaoService.buscarTodos();
	}
	
	@PostMapping("/")
	public Permissao inserir(@RequestBody Permissao pessoa) {
		return permissaoService.inserir(pessoa);
	}
	
	@PutMapping("/")
	public Permissao alterar(@RequestBody Permissao pessoa) {
		return permissaoService.alterar(pessoa);
	}
	
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		permissaoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
