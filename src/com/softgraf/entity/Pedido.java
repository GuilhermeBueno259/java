package com.softgraf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	private Integer id;
	private Date data;
	private Cliente cliente;
	private List<Item> itens;

	public Pedido() {
		itens = new ArrayList<Item>();
	}

	public Pedido(Date data, Cliente cliente) {
		this();
		this.data = data;
		this.cliente = cliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void addItem(Item item) {
		itens.add(item);
	}

	@Override
	public String toString() {
		return String.format("Id: %-5d\nData: %s\nCliente: %s", id, data.toString(), cliente.getNome());
	}
}
