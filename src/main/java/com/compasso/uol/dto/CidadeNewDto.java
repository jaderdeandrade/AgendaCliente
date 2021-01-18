package com.compasso.uol.dto;

import java.io.Serializable;

import com.compasso.uol.domain.Cidade;

public class CidadeNewDto implements Serializable{
	
	/**
	 * Jader de Andrade
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public CidadeNewDto() {
		
	}
	
	public CidadeNewDto(Cidade obj) {
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
	
}
