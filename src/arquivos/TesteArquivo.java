package arquivos;

public class TesteArquivo {

	public static void main(String[] args) {
		String arquivo = "D:\\Curso Java Guilherme Bueno\\aula07\\src\\arquivos\\texto.txt";
		LeituraGravacao.gravar(arquivo);
		LeituraGravacao.ler(arquivo);
	}
}
