package br.com.campos.cursomc.domain;

import lombok.Getter;

@Getter
public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer id;
	private String descricao;

	private TipoCliente(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static TipoCliente findTipo(Integer id) {

		if (id == null) {
			return null;
		}

		for (TipoCliente tc : TipoCliente.values()) {
			if (id.equals(tc.getId())) {
				return tc;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + id);

	}

}
