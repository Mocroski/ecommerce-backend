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

import com.devmocroski.backend.entity.Marca;
import com.devmocroski.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@GetMapping("/")
	public List<Marca> buscarTodos() {
		return marcaService.buscarTodos();
	}

	@PostMapping("/")
	public Marca inserir(@RequestBody Marca pessoa) {
		return marcaService.inserir(pessoa);
	}

	@PutMapping("/")
	public Marca alterar(@RequestBody Marca pessoa) {
		return marcaService.alterar(pessoa);
	}

	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		marcaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
