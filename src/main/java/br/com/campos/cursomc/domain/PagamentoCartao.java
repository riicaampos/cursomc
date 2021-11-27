package br.com.campos.cursomc.domain;

import javax.persistence.Entity;

import br.com.campos.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numParcelas;
	
	
	public PagamentoCartao() {
		
	}


	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido,
			Integer numParcelas) {
		super(id, estado, pedido);
		this.numParcelas = numParcelas;
	}
	
	

}
