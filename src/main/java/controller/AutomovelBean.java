package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Automovel;
import model.JpaUtil;

@ManagedBean(name = "automovelBean") // name opcional
@SessionScoped // padr�o: RequestScoped
// todo managed bean deve ter um construtor padr�o
public class AutomovelBean {
	private Automovel automovel;

	// construtor padr�o obrigat�rio
	public AutomovelBean() {
		this.automovel = new Automovel();
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public String salvar(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		// inicia transa��o
		em.getTransaction().begin();

		em.persist(automovel);

		// finaliza transa��o
		em.getTransaction().commit();
		em.close();

		this.automovel = new Automovel();
		return "";
	}

	public String excluir(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		// inicia transa��o
		em.getTransaction().begin();

		// anexa a entidade ao Entity Manager (torna gerenci�vel)
		Automovel auto = em.merge(automovel);
		em.remove(auto);

		// finaliza a transa��o
		em.getTransaction().commit();
		em.close();

		return "";
	}

	public List<Automovel> getAutomoveis() {
		List<Automovel> lista;

		EntityManager em = JpaUtil.getEntityManager();
		// cria uma consulta no Entity Manager (banco de dados), usando linguagem JPQL
		// JPQL = Java Persistence Query Language
		TypedQuery<Automovel> q = em.createQuery("SELECT a FROM Automovel a", Automovel.class);
		// executa a consulta
		lista = q.getResultList();
		em.close();
		
		return lista;
	}
}
