package excecoes;

public class Converter {
	public static int paraInteiro(String valor) throws MinhaExcecao {
		try {
			int v = Integer.parseInt(valor);
			return v;
		} catch (NumberFormatException e) {
			MinhaExcecao excessao = new MinhaExcecao("Erro de convers�o de valor!");
			throw excessao;
		}
	}
}
