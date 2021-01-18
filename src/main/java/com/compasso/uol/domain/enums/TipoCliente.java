package com.compasso.uol.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pesso Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer cod;
	private String descrcicao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descrcicao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescrcicao() {
		return descrcicao;
	}
//O método pode ser executado sem precisar instanciar o objeto
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
			throw new IllegalArgumentException("Id inválido" + cod);
	}

}