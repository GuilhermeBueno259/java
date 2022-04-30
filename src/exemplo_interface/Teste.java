package exemplo_interface;

public class Teste {

	public static void main(String[] args) {
		TvSamsung tv = new TvSamsung();
		tv.ligar();
		
		tv.aumentarVolume(30);
		tv.mudarCanal(10);
		
		tv.desligar();
		
	}

}
