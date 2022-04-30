package exemplo_interface;

// Uma interface � uma classe 100% abstrata, ou seja todos os m�todos s�o abstratos
// Voc� pode interpretar uma interface como um contrato
public interface ControleRemoto {

	// Implicitamente p�blico e abstrato
	void mudarCanal(int canal);
	
	void aumentarVolume(int taxa);
	
	void diminuirVolume(int taxa);
	
	boolean ligar();
	
	boolean desligar();
}
