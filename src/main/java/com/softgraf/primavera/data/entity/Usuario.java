package com.softgraf.primavera.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "password", length = 200, nullable = false)
	private String senha;

	@Column(name = "enabled", nullable = false)
	private Boolean ativo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
