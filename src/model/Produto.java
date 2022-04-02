package model;

public class Produto {

	private String nome;
	private int quantidadeEstoque;
	private float precoUnitario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public String toString() {
		return String.format("Produto: %-20s Quantidade: %-7d Preço: R$ %-7.2f", this.nome, this.quantidadeEstoque,
				this.precoUnitario);
	}

}
