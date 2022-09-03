package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("automoveis_pu");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
		
		/*
		 * 
		 */
	}
}
