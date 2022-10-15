package com.softgraf.farmacia.repositorio;

import java.io.Serializable;
import java.util.List;

/*
 * Pacotes para escopos
 * javax.faces.bean  -> bean JSF
 * javax.faces.view  -> bean JSF (Primefaces)
 * javax.enterprise.context  -> bean CDI (pacote Weld)
 */

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgraf.farmacia.entity.Cliente;

/*
 * Um repositório representa uma coleção de objetos de um tipo específico.
 * É um meediador entre a camada de negócios e o a ceso a dados
 * Deve fonecer métodos para adicionar, remover, atualizar, buscar, listar, etc.
 */

//@RequestScoped
public class RepositorioClientes implements Serializable {
	private static final long serialVersionUID = -5841325902476402508L;
	private EntityManager em;

	// Todo bean necessita de um construtor padrão
	public RepositorioClientes() {
	}

	public RepositorioClientes(EntityManager em) {
		this.em = em;
	}

	public void adicionar(Cliente cliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cliente);
		tx.commit();
	}

	public void removerPorId(Integer id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Cliente.class, id));
		tx.commit();
	}

	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);
	}

	public void atualizar(Cliente cliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(cliente);
		tx.commit();
	}

	public List<Cliente> todos() {
		// select c from Cliente c = from CLiente
		return em.createQuery("from Cliente", Cliente.class).getResultList();
	}

	// lista todas as cidades que tem o nome parecido (like) com o parametro passado
	public List<String> pesquisarCidades(String cidade) {
		return em.createQuery("select distinct cidade from Cliente where upper(cidade) like upper(:cidade)",
				String.class).setParameter("cidade", "%" + cidade + "%").getResultList();
	}
}
