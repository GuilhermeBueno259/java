package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Editora implements Serializable {
	private static final long serialVersionUID = -5439557620945625108L;

	private Long id;
	private String nomeEditora;
	private List<Livro> livros;

	// contrutor padrão
	public Editora() {
		this.livros = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100, name = "nome_editora", unique = true)
	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	@OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Transient
	public Integer getTotalDeLivros() {
		return livros.size();
	}

	// Não vai ser usado
	public void setTotalDeLivros(Integer totalLivros) {
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeEditora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editora other = (Editora) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeEditora, other.nomeEditora);
	}

	@Override
	public String toString() {
		return String.format("ID: %d\tNome: %s", id, nomeEditora);
	}
}
