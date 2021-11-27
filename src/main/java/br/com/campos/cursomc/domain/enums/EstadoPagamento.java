package br.com.campos.cursomc.domain.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private Integer id;
	private String descricao;

	private EstadoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static EstadoPagamento findEstado(Integer id) {

		if (id == null) {
			return null;
		}

		for (EstadoPagamento tc : EstadoPagamento.values()) {
			if (id.equals(tc.getId())) {
				return tc;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + id);

	}

}
