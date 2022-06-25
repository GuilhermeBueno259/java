package com.softgraf.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.entity.Cliente;
import com.softgraf.util.JpaUtil;

public class Remover {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Cliente cliente = em.find(Cliente.class, 1);

		tx.begin();
		em.remove(cliente);
		tx.commit();

		em.close();
		JpaUtil.close();
	
	}

}
