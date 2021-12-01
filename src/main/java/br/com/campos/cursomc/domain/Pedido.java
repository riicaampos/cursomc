package br.com.campos.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of="id")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date instante;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	/**
	 * Necessario usar o cascade para evitar o erro de entidade transiente
	 */
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.pedido")
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<ItemPedido> itens;
	
	
	public Pedido() {
		 this.itens = new HashSet<>();
	}


	public Pedido(Integer id, Date instante, Cliente cliente, Endereco endereco) {
		super();
		this.itens = new HashSet<>();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.endereco = endereco;
	}
	
	
	
}
