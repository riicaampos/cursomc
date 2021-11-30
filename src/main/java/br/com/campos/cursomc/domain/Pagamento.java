package br.com.campos.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.campos.cursomc.domain.enums.EstadoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of="id")
public abstract class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
    private Integer estado;
    
    /**
     * @MapsId garante que o id dessa entidade vai ser o mesmo id da entidade relacionada
     */
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;
    
    public Pagamento() {
    	
    }

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getId();
		this.pedido = pedido;
	}
	
	public EstadoPagamento getEstado() {
		return EstadoPagamento.findEstado(this.estado);
	}
	
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getId();
	}
    
    
	
}
