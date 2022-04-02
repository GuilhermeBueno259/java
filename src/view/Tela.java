package view;

import java.util.Scanner;
import model.Produto;
import static java.lang.System.out;

public class Tela {

	public static Produto mostrar() {
		Scanner input = new Scanner(System.in);
		Produto produto = new Produto();

		out.println("Nome do produto: ");
		produto.setNome(input.nextLine().toUpperCase());

		out.println("Quantidade em estoque: ");
		produto.setQuantidadeEstoque(input.nextInt());

		out.println("Pre�o unit�rio: ");
		produto.setPrecoUnitario(input.nextFloat());

		return produto;
		
	}
}
