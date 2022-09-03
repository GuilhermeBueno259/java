package dominio;

public class Funcionario {

	private Integer id;
	private String nome;
	private Integer idade;
	private Float salario;

	// construtor padrão = sem argumentos
	public Funcionario() {

	}

	// construtor com 1 argumento
	public Funcionario(String nome) {
		this.nome = nome;
	}

	// construtor com 2 argumentos
	public Funcionario(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	// construtor com 3 argumentos
	public Funcionario(Integer id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	// construtor de 4 argumentos
	public Funcionario(Integer id, String nome, Integer idade, Float salario) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("ID: %-5d Nome: %-20s Idade: %-5d Salario: R$ %-5.2f", id, nome, idade, salario);
	}

	public void info() {
		System.out.println(toString());
	}

}
