package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import entidades.Editora;
import entidades.Livro;
import util.JpaUtil;

@ManagedBean
@ViewScoped
public class EditoraMB implements Serializable {
	private static final long serialVersionUID = -6878492634529627007L;

	private Editora editora;
	private Livro livro;
	private Long paramId;
	private Modo modo;

	private EntityManager em;

	public EditoraMB() {
		this.editora = new Editora();
		this.livro = new Livro();
		this.paramId = null;
		this.modo = Modo.INCLUSAO;
		this.em = JpaUtil.getEntityManager();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

	public Modo getModo() {
		return modo;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	public String salvarEditora() {
		if (editora != null) {
			try {
				em.getTransaction().begin();
				if (modo == Modo.INCLUSAO) {
					em.persist(editora);
				}
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.modo = Modo.INCLUSAO;
		this.editora = new Editora();
		return "index";
	}
}
