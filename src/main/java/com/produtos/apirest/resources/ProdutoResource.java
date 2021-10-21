package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController // Indicando que é um controlador de requisições rest
@RequestMapping(value = "/api") // Endpoint padrão
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository; // instânciando o obj da interface para interagir com o DB

	// Endpoint que responde ao get via http request
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		// método que irá retornar uma lista com todos os produtos cadastrados
		return produtoRepository.findAll();
	}

	// Endpoint que responde ao get via http request
	@GetMapping("/produto/{id}")
	public Produto buscarProduto(@PathVariable long id) {
		// método que irá buscar por id um produto cadastrado
		return produtoRepository.findById(id);
	}

	// Endpoint que responde ao post via http request
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		// método que recebe um produto no body da requisição e salva DB
		return produtoRepository.save(produto);
	}

	// Endpoint que recebe a requisição PUT via HTTP
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	// Endpoint que recebe a requisição DELETE com id com parâmetro via HTTP
	@DeleteMapping("/produto/{id}")
	public void deletarProduto(@PathVariable(value = "id") long id) {
		produtoRepository.deleteById(id);
	}

	// Endpoint que recebe a requisição DELETE via HTTP
	@DeleteMapping("/produto")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
}
