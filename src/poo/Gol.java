package poo;

public class Gol extends Automovel implements Radio {
	public Gol(Motor motor) {
		super(motor);
	}

	@Override
	public void tocarMusica() {
		System.out.println("AE EEE AO OOO");
	}
}
