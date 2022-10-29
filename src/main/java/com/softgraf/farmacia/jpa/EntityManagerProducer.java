package com.softgraf.farmacia.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped // pacote javax.enterprise.context
// este objeto existirá enquanto a aplicação estiver em execução (Application)
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	// construtor
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("farmaciaPU");
	}

	// cria o entity manager
	@Produces // método produtorm gera u m objeto que pode ser injetado
	@RequestScoped // javax.enterprise.context
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	// fecha o entitymanager
	// @Disposes: método finalizador: executado automaticamente quando
	// o escopo onde o objeto foi produzido terminar (request, neste caso)
	// pacote javax.enterprise.context
	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}

}