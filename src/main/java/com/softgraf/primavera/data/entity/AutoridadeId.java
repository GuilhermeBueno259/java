package com.softgraf.primavera.data.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
// classe que define uma chave composta
public class AutoridadeId implements Serializable {

	private static final long serialVersionUID = 7013167261372463249L;

	@Column(name = "username", length = 50, nullable = false)
	private String nomeUsuario;

	@Column(name = "authority", length = 50, nullable = false)
	private String autorizacao;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autorizacao, nomeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoridadeId other = (AutoridadeId) obj;
		return Objects.equals(autorizacao, other.autorizacao) && Objects.equals(nomeUsuario, other.nomeUsuario);
	}

}
