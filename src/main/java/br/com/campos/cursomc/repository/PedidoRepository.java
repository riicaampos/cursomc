package br.com.campos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.campos.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
