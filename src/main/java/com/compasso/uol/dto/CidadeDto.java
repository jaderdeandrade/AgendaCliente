package com.compasso.uol.dto;

import java.io.Serializable;

import com.compasso.uol.domain.Cidade;

public class CidadeDto implements Serializable{
	
	/**
	 * Jader de Andrade
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Integer estadoId;
	
	public CidadeDto() {
		
	}
	
	public CidadeDto(CidadeNewDto obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}


	
}
