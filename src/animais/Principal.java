package animais;

public class Principal {

	public static void main(String[] args) {

		Animal animal = new Animal();

		animal.setEspecie("Mamífero");

		animal.dormir();
		animal.comer();
		animal.locomover();

		Mamifero mamifero = new Mamifero();
		mamifero.comer();
		mamifero.dormir();
		mamifero.locomover();
		mamifero.mamar();

		Reptil reptil = new Reptil();
		reptil.rastejar();
		reptil.dormir();

		Ave ave = new Ave();
		ave.voar();

		Gato gato = new Gato();
		gato.miar();
		gato.locomover();

		Cao cao = new Cao();
		cao.latir();
		cao.locomover();
	}

}
