package br.com.campos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.campos.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
