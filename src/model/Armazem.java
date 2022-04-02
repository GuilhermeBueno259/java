package model;

import java.util.ArrayList;
import java.util.List;

public class Armazem {

	static List<Produto> produtos = new ArrayList<>();
	static int indice = 0;

	public static void guardar(Produto produto) {
		produtos.add(produto);

	}

	public static void imprimir() {
		produtos.forEach(System.out::println);
	}

}
