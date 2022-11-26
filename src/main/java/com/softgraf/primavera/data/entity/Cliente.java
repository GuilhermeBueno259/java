package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.softgraf.primavera.data.model.GrupoCnpj;
import com.softgraf.primavera.data.model.GrupoCpf;
import com.softgraf.primavera.data.model.TipoPesssoa;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 414789771607776382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Tipo de pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8)
	private TipoPesssoa tipoPessoa;

	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 60)
	@Column(length = 60, nullable = false)
	private String nome;

	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = GrupoCpf.class)
	@CNPJ(groups = GrupoCnpj.class)
	@Column(name = "cpf_cnpj", nullable = false)
	private String cpfOuCnpj;

	@Size(max = 60)
	@Email(message = "E-mail inválido")
	@Column(length = 60)
	private String email;

	@Column(length = 14)
	private String fone;

	@Embedded
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPesssoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPesssoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
