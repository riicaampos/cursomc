package br.com.campos.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.campos.cursomc.domain.enums.TipoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of="id")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	
	
	@OneToMany(mappedBy = "cliente")
	private Set<Endereco> enderecos;
	
	/**
	 * Usa @ElementCollection quando se tem uma lista de uma entidade fraca,
	 * ou seja não tem uma tabela (classe) criada
	 */
	@ElementCollection
	@CollectionTable(name = "telefone")
	private Set<String> telefones;
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	public Cliente() {
		this.enderecos = new HashSet<>();
		this.telefones = new HashSet<>();
		this.pedidos = new ArrayList<>();
	}

	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getId();
	}
	
	public TipoCliente getTipo() {
		return TipoCliente.findTipo(this.tipo);
	}
	
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getId();
	}
	
 
}

