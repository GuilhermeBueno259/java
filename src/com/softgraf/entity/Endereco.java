package com.softgraf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	private Integer id;
	private String rua;
	private String cidade;
	private String estado;

	public Endereco() {
	}

	public Endereco(String rua, String cidade, String estado) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(length = 20)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(length = 20)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return String.format("Rua: %s\nCidade: %s\nEstado: %s\n", rua, cidade, estado);
	}
}
