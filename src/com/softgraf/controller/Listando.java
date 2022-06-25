package com.softgraf.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.softgraf.entity.Pedido;
import com.softgraf.util.JpaUtil;

public class Listando {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();

		// lista todos os pedidos da tabela(entidade) Pedido
		// JPA usa JPQL (Java Persistence Query Language), mas também pode utilizar SQL
		// nativo
		List<Pedido> pedidos = em.createQuery("from Pedido", Pedido.class).getResultList();

		System.out.println("Lista de pedidos retornada");

		pedidos.forEach(System.out::println);
	}

}
