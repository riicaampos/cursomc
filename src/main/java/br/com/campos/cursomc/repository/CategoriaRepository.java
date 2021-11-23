package br.com.campos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.campos.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
