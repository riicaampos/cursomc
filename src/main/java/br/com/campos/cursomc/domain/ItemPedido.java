package br.com.campos.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK id;
	
	private Double desconto;
	private Integer qnt;
	private Double preco;
	
	public ItemPedido() {
		this.id = new ItemPedidoPK();
	}

	public ItemPedido(Produto produto, Pedido pedido, Double desconto, Integer qnt, Double preco) {
		super();
		id = new ItemPedidoPK();
		id.setProduto(produto);
		id.setPedido(pedido);
		this.desconto = desconto;
		this.qnt = qnt;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}
	
}
