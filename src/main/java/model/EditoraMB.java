package model;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Editora salva/atualizada"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro!", "Não foi possível salvar/atualizar editora"));
			}
		}

		this.modo = Modo.INCLUSAO;
		this.editora = new Editora();
		return "index";
	}

	public List<Editora> getEditoras() {
		return em.createQuery("SELECT e FROM Editora e", Editora.class).getResultList();
	}

	public List<Livro> getLivros() {
		return em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
	}

	public String salvarLivro() {
		if (livro != null) {
			try {
				em.getTransaction().begin();

				livro.getEditora().getLivros().add(livro);

				if (modo == Modo.INCLUSAO) {
					em.persist(livro);
				}
				em.getTransaction().commit();

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Livro salvo/atualizado"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro!", "Não foi possível salvar/atualizar o livro"));
			}
		}

		this.modo = Modo.INCLUSAO;
		this.livro = new Livro();
		return "index";
	}

	public void editarEditora() {
		if (paramId != null) {
			this.modo = Modo.EDICAO;
			this.editora = em.find(Editora.class, paramId);
			paramId = null;
		}
	}

	public void editarLivro() {
		if (paramId != null) {
			this.modo = Modo.EDICAO;
			this.livro = em.find(Livro.class, paramId);
			paramId = null;
		}
	}

	public String excluirEditora() {
		try {
			em.getTransaction().begin();
			em.remove(editora);
			em.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
					"Editora com todos os livros foram excluidos"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível excluir a editora"));
		}
		this.editora = new Editora();
		return "";
	}

	public String excluirLivro() {
		try {
			em.getTransaction().begin();
			em.remove(livro);
			livro.getEditora().getLivros().remove(livro);
			em.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O livro foi excluído"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível excluir o livro"));
		}
		this.livro = new Livro();
		return "";

	}
}