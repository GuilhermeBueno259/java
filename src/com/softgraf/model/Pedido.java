package com.softgraf.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Pedido {

	private int numero;
	private Date data;
	private Cliente cliente;
	private List<Item> lista = new ArrayList<>();

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean addItem(Item item) {
		return lista.add(item);
	}
	
	public boolean removerItem(Item item) {
		return lista.remove(item);
	}
	
	public boolean removerItem(int index) {
		return lista.remove(index) != null;
	}
	
	public List<Item> listaItens() {
		return Collections.unmodifiableList(lista);
	}
}
