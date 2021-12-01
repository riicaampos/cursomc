package br.com.campos.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Double preco;

	/**
	 * Anotação @JoinTable nome da tabela que será criada joinColumns = @JoinColumn
	 * nome da coluna que terá a chave estrangeira correspondente ao produto
	 * inverseJoinColumns = @JoinColumn chave da outra classe que é feito o
	 * relacionamento
	 * 
	 * @JsonBackReference indica que a lista deve ser carregada apenas do outro lado, ou seja
	 * quando eu retornas as categorias, a lista de produtos será retornada junto, e quando
	 * for consultado os produtos, não será retornado as categorias
	 */
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
	    joinColumns = @JoinColumn(name = "produto_id"), 
	    inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<ItemPedido> itens;

	public Produto() {
		this.categorias = new ArrayList<>();
		this.itens = new HashSet<>();
	}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.itens = new HashSet<>();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	/**
	 * Tudo que começa com get... automaticamente é serializado
	 * então é necessário usar @JsonIgnore
	 */
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> peds = new ArrayList<>();
		for(ItemPedido i : itens) {
			peds.add(i.getPedido());
		}
		return peds;
	}

}
