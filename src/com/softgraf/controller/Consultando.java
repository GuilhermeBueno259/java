package com.softgraf.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.softgraf.entity.Cliente;
import com.softgraf.entity.Endereco;
import com.softgraf.util.JpaUtil;

public class Consultando {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();

		// Buscando cliente contendo a palavra "santos"
		List<Cliente> listaSantos = em.createQuery("from Cliente c where c.nome like '%santos%'", Cliente.class)
				.getResultList();
		listaSantos.forEach(System.out::println);

		// Buscando todos os enderecos dos clientes
		em.createQuery("select c.endereco from Cliente c where c.endereco.rua like '%XV%'", Endereco.class)
				.getResultList().forEach(System.out::println);

		// Buscando apenas o nome da cidade do endereço do cliente "João da Silva"
		System.out.println(
				em.createQuery("select c.endereco.cidade from Cliente c where c.nome = 'Joao da Silva'", String.class)
						.getSingleResult());

		em.close();
		JpaUtil.close();

	}

}
