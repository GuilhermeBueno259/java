package poo;

public class Bmw extends Automovel implements Radio, Gps, ArCondicionado {
	public Bmw(Motor motor) {
		super(motor);
	}

	@Override
	public void tocarMusica() {
		System.out.println("Tocando música...");
	}

	@Override
	public void gelar() {
		System.out.println("Ar Condicionado gelando o ar...");
	}

	@Override
	public void seguir(Endereco endereco) {
		System.out.println("Vire à esquerda");
		System.out.println("Rode 1 Km");
		System.out.println("Chegou ao destino!");
	}

}
