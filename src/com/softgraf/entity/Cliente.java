package com.softgraf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	private Integer id;
	private String nome;
	private Endereco endereco;
	private List<Pedido> pedidos;

	public Cliente() {
		pedidos = new ArrayList<Pedido>();
	}

	public Cliente(String nome, Endereco endereco) {
		this();
		this.nome = nome;
		this.endereco = endereco;
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
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	@Override
	public String toString() {
		return String.format("Id: %d\nNome: %s\nEndereço: %s - %s - %s", id, nome, endereco.getRua(),
				endereco.getCidade(), endereco.getEstado());
	}
}
