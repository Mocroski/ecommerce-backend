package com.devmocroski.backend.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.devmocroski.backend.entity.Produto;
import com.devmocroski.backend.entity.ProdutoImagens;
import com.devmocroski.backend.repository.ProdutoImagensRepository;
import com.devmocroski.backend.repository.ProdutoRepository;

public class ProdutoImagensService {

	@Autowired
	private ProdutoImagensRepository produtoImagensRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoImagens> buscarTodos() {
		return produtoImagensRepository.findAll();
	}

	public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
		Produto produto = produtoRepository.findById(idProduto).get();
		ProdutoImagens objeto = new ProdutoImagens();

		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
				Path caminho = Paths.get("C:\\Development\\Workspace\\Ecommerce\\backend\\imagens" + nomeImagem);
				Files.write(caminho, bytes);
				objeto.setNome(nomeImagem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		objeto.setProduto(produto);
		objeto.setDataCriacao(new Date());
		objeto = produtoImagensRepository.saveAndFlush(objeto);
		return objeto;
	}

	public ProdutoImagens alterar(ProdutoImagens objeto) {
		objeto.setDataAtualizacao(new Date());
		return produtoImagensRepository.saveAndFlush(objeto);
	}

	public void excluir(Long id) {
		ProdutoImagens objeto = produtoImagensRepository.findById(id).get();
		produtoImagensRepository.delete(objeto);
	}
}
