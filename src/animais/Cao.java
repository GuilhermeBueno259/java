package animais;

public class Cao extends Mamifero{

	public void latir() {
		System.out.println("O cão latiu...");
	}
	
	@Override
	public void locomover() {
		System.out.println("Cão correndo...");
	}
	
}
