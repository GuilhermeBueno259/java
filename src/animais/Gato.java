package animais;

public class Gato extends Mamifero{

	public void miar() {
		System.out.println("O gato miou...");
	}
	@Override
	public void locomover() {
		System.out.println("Gato correndo...");
	}
}
