package com.softgraf.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.entity.Cliente;
import com.softgraf.entity.Pedido;
import com.softgraf.util.JpaUtil;

public class Atualizando3 {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Cliente cliente = em.find(Cliente.class, 1);
		List<Pedido> pedidos = cliente.getPedidos();
		Pedido pedido = pedidos.get(0);
		System.out.println(pedido);

		pedido.setData(new Date());
		System.out.println(pedido);
		tx.commit();

		em.close();
		JpaUtil.close();
	}

}
