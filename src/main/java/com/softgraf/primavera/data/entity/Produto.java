package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos") // nome da tabela (opcional)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1948263887314040596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * AUTO = o banco de dados escolhe a estratégia IDENTITY = valor gerado pela
	 * coluna de auto incremento do banco, nem todos os bancos de dados suportam
	 * esta opção. SEQUENCE = valor gerado por uma sequência, que se não for
	 * especificada, será global gerada pelo banco, para todas as entidades. TABLE =
	 * é necessário criar uma tabela para gerenciar as chaves primárias. Essa opção
	 * não é recomendada.
	 */
	private Long id;

	@NotBlank(message = "Descrição do produto é obrigatório!") // Bean Validation!
	@Column(length = 60, nullable = false)
	private String descricao;

	@DecimalMin(value = "0.0", inclusive = false, message = "Preço abaixo do mínimo")
	@DecimalMax(value = "9999.0", message = "Preço acima do máximo")
	@Column(nullable = false)
	private Float preco;

	@NotNull(message = "Quantidade é obrigatório")
	@Min(1)
	@Max(9999)
	@Column(nullable = false)
	private Integer quantidade;

	@Column(length = 60)
	private String urlImagem;

	// Contrutor padrão
	public Produto() {
	}

	public Produto(String descricao, Float preco, Integer quantidade) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto(String descricao, Float preco, Integer quantidade, String urlImagem) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.urlImagem = urlImagem;
	}

	public Produto(Long id, String descricao, Float preco, Integer quantidade) {
		this(descricao, preco, quantidade);
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("ID: %-5d Descrição: %-30s Preço: R$ %-10.2f Quantidade: %-5d", id, descricao, preco,
				quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
