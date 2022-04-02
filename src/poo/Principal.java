package poo;

public class Principal {

	public static void main(String[] args) {

		Motor motor70cv = new Motor(70);
		Motor motor200cv = new Motor(200);
		
		Automovel gol = new Gol(motor70cv);
		Automovel palio = new Palio(motor70cv);
		Automovel bmw = new Bmw(motor200cv);

		FabricaVeiculos fabrica = FabricaVeiculos.getInstancia();
		FabricaVeiculos fabrica2 = FabricaVeiculos.getInstancia();
		
		System.out.println(fabrica);
		System.out.println(fabrica2);
		
		fabrica.adicionar(gol);
		fabrica.adicionar(palio);
		fabrica.adicionar(bmw);

		for (Object v : fabrica.listar()) {
			System.out.println(v);
		}
		
		((Palio)palio).gelar();
	}
}
