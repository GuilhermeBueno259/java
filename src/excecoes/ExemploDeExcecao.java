package excecoes;

public class ExemploDeExcecao {

	public static void main(String[] args) {
		try {
			Integer i = Converter.paraInteiro("12#");
			System.out.println(i + 1);
		} catch (MinhaExcecao e) {
			System.out.println("Erro na entrada: " + e.getMessage());
		} finally {
			System.out.println("Executa com ou sem excessão!");
		}
		System.out.println("Fim do programa!");
	}
}
