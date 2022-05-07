package model;

public class Aluno {
	private long id;
	private String nome;
	private String cpf;
	private String fone;

	public Aluno() {
	}

	public Aluno(String nome, String cpf, String fone) {
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
	}

	public Aluno(long id, String nome, String cpf, String fone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Override
	public String toString() {
		return String.format("\nMatricula: %d\nNome: %s\nCPF: %s\nFone: %s\n", id, nome, cpf, fone);
	}

}
