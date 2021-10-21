package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
// Interface que extende de JpaRepository o qual já possui recursos(metodos genéricos) para persistência de dados
	
	Produto findById(long id);
	
}
