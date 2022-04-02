package view;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

	public static int mostrar() {
		
		int opcao;
		Scanner input = new Scanner(System.in);
		PrintStream s = System.out;
		
		s.println("####################################");
		s.println("# Bem-vindo ao controle de estoque #");
		s.println("1 - Cadastrar produto");
		s.println("2 - Imprimir produtos");
		s.println("3 - Apagar produto");
		s.println("4 - Editar produto");
		s.println("0 - Sair do Programa");
		
		do {
			s.println("Qual a opção? ");
			opcao = input.nextInt();
		} while (opcao < 0 || opcao > 5);
		
		return opcao;
	}
	
}
