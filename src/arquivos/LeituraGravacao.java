package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeituraGravacao {

//	Método estático é aquele que posso acessar sem criar um objeto
	public static void gravar(String arquivo) {
		try {
			FileWriter gravador = new FileWriter(arquivo);

			gravador.write("Primeira linha\n");
			gravador.write("qwerty\n");
			gravador.write("Outra linha...\n");
			gravador.write("0123456789\n");

			gravador.close();
			System.out.println("Arquivo gravado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro durante gravação do arquivo:\n " + arquivo);
			e.getStackTrace();
		}
	}

	public static void ler(String arquivo) {
		try {
			FileReader leitor = new FileReader(arquivo);
			BufferedReader reader = new BufferedReader(leitor);

			String linha;
			while ((linha = reader.readLine()) != null) {
				System.out.println(linha);
			}

			leitor.close();
			reader.close();
			System.out.println("Arquivo lido com sucesso!");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não pode ser encontrado:\n " + arquivo);
			e.getStackTrace();
		} catch (IOException e) {
			System.out.println("Erro durante a leitura do arquivo:\n " + arquivo);
			e.getStackTrace();
		}
	}
}
