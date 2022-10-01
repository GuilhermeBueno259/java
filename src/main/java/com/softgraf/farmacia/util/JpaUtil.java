package com.softgraf.farmacia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// classe utilitária, a qual acessa persistence.xml para fazer conexão com o banco de dados
public class JpaUtil {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("farmaciaPU");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}
