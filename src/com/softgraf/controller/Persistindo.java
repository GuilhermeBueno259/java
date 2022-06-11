package com.softgraf.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.entity.Cliente;
import com.softgraf.entity.Endereco;
import com.softgraf.entity.Item;
import com.softgraf.entity.Pedido;
import com.softgraf.entity.Produto;
import com.softgraf.util.JpaUtil;

public class Persistindo {

	public static void main(String[] args) {
		Endereco ruaXV = new Endereco("Rua XV de Novembro, 123", "Ponta Grossa", "Paraná");
		Cliente joao = new Cliente("João da Silva", ruaXV);
		Produto produto = new Produto("Pão", 5.90f);
		Produto bala = new Produto("Sete Belo", 7.50f);
		Pedido pedido = new Pedido(new Date(), joao);

		Item item1 = new Item(10, pedido, produto);
		Item item2 = new Item(3, pedido, bala);

		pedido.addItem(item1);
		pedido.addItem(item2);

		joao.addPedido(pedido);

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(joao);
		tx.commit();

		em.close();
		JpaUtil.close();
	}

}
