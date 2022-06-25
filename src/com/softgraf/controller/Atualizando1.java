package com.softgraf.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.entity.Cliente;
import com.softgraf.entity.Endereco;
import com.softgraf.util.JpaUtil;

public class Atualizando1 {

	public static void main(String[] args) {
		Endereco rua = new Endereco("Rua Dr. Colares 123", "Ponta Grossa", "PR");
		Cliente luiz = new Cliente("Luiz Carlos", rua);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		// inicia a transa��o
		tx.begin();
		// salva cliente
		em.persist(luiz);
		// confirma a transa��o
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
