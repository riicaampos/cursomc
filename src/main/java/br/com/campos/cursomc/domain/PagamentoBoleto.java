package br.com.campos.cursomc.domain;


import java.util.Date;

import javax.persistence.Entity;

import br.com.campos.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
     private Date dataVencimento;
     private Date dataPagamento;
     
     
     public PagamentoBoleto() {
    	 
     }
     
     public PagamentoBoleto(Integer id, EstadoPagamento estado,Pedido pedido, 
    		 Date dataVencimento, 
    		 Date dataPagamento) {
    	super(id,estado,pedido);
    	this.dataVencimento = dataVencimento;
    	this.dataPagamento = dataPagamento;
    		
     }

}
