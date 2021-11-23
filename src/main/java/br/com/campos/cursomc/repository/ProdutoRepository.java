package br.com.campos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.campos.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
