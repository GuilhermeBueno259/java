package com.softgraf.dao;

import java.util.Date;

// Classe Javabean
public class Contato {

	private Integer id;
	private String nome;
	private String fone;
	private String email;
	private Date data;

	// Javabean precisa de um construtor padrão
	public Contato() {
	}

	public Contato(Integer id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = null;
		this.data = null;
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
