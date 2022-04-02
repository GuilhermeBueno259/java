package controller;

import view.Menu;
import java.util.Scanner;
import model.Armazem;
import model.Produto;
import view.Tela;

public class Principal {

	public static void main(String[] args) {
		
		Menu.mostrar();

		char resposta;
		Produto produto;

		Scanner input = new Scanner(System.in);

		do {
			produto = Tela.mostrar();
			Armazem.guardar(produto);
			System.out.println("Deseja cadastrar outro produto? Sim ou Não: ");
			resposta = input.next().toUpperCase().charAt(0);
		} while (resposta == 'S');

		Armazem.imprimir();

	}

}
