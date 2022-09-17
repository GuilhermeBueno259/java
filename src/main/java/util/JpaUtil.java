package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory emf;

	static {
		System.out.println("Rodou inicializador estático");
		emf = Persistence.createEntityManagerFactory("editora_pu");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
