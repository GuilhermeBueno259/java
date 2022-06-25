package com.softgraf.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.entity.Cliente;
import com.softgraf.util.JpaUtil;

public class Atualizando2 {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Cliente cliente = em.find(Cliente.class, 2);
		cliente.setNome("Márcio Oliveira dos Santos");
		tx.commit();

		em.close();
		JpaUtil.close();
	}

}
