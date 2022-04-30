package exemplo_interface;

// Uma interface é uma classe 100% abstrata, ou seja todos os métodos são abstratos
// Você pode interpretar uma interface como um contrato
public interface ControleRemoto {

	// Implicitamente público e abstrato
	void mudarCanal(int canal);
	
	void aumentarVolume(int taxa);
	
	void diminuirVolume(int taxa);
	
	boolean ligar();
	
	boolean desligar();
}
