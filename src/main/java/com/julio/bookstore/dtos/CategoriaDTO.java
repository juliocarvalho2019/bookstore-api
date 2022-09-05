package com.julio.bookstore.dtos;

import java.io.Serializable;

import com.julio.bookstore.domain.Categoria;

public class CategoriaDTO implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descriçãoString;
	
	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descriçãoString = obj.getDescricao();
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

	public String getDescriçãoString() {
		return descriçãoString;
	}

	public void setDescriçãoString(String descriçãoString) {
		this.descriçãoString = descriçãoString;
	}
	
	

}
