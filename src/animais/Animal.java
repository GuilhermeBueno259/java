package animais;

public class Animal {

	private String nome;
	private String especie;
	
	public void dormir() {
		System.out.println("Animal dormindo...");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void comer() {
		System.out.println("Animal comendo...");
	}

	public void locomover() {
		System.out.println("Animal locomovendo-se...");
	}

}
