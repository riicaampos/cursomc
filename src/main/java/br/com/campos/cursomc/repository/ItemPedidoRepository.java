package br.com.campos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.campos.cursomc.domain.ItemPedido;
import br.com.campos.cursomc.domain.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{

}
