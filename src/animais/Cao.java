package animais;

public class Cao extends Mamifero{

	public void latir() {
		System.out.println("O c�o latiu...");
	}
	
	@Override
	public void locomover() {
		System.out.println("C�o correndo...");
	}
	
}
