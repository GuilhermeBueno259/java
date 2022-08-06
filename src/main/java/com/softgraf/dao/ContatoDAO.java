package com.softgraf.dao;

import java.util.ArrayList;
import java.util.List;

// Classe Javabean
public class ContatoDAO {

	private List<Contato> lista;

	public ContatoDAO() {
		this.lista = new ArrayList<Contato>();
		lista.add(new Contato(1, "João da Silva", "(42) 98765-4321"));
		lista.add(new Contato(2, "Maria Pereira", "(42) 98766-9322"));
		lista.add(new Contato(3, "Pedro Martins", "(42) 98915-4625"));
	}

	public List<Contato> getLista() {
		return lista;
	}
	
	public void addContato(Contato contato) {
		this.lista.add(contato);
	}
	
}
