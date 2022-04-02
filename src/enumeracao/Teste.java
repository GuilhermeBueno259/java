package enumeracao;

public class Teste {

	public static void main(String[] args) {
		Semana dia = Semana.SEGUNDA;
		System.out.println(dia.compareTo(Semana.DOMINGO));

		// pegue cada dia da semana e imprime
		for (Semana s : Semana.values()) {
			System.out.println(s);
		}
	}

}
