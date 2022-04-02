package poo;

public class Palio extends Automovel implements ArCondicionado {
	public Palio(Motor motor) {
		super(motor);
	}

	@Override
	public void gelar() {
		System.out.println("Ar Condicionado gelando...");
	}
}
