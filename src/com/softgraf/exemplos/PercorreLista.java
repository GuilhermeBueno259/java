package com.softgraf.exemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PercorreLista {

	public static void main(String[] args) {
		List<String> frutas = new ArrayList<String>();
		frutas.add("Uva");
		frutas.add("Maçã");
		frutas.add("Pera");

		// percorrendo a lista com for normal
		System.err.println("Percorrendo a lista com for normal");
		for (int i = 0; i < frutas.size(); i++) {
			System.out.println(frutas.get(i));
		}

		// percorrendo a lista com foreach
		System.err.println("Percorrendo a lista com foreach");
		for (String string : frutas) {
			System.out.println(string);
		}

		// percorrendo a lista com foreach funcional
		// a partir do Java 8
		System.err.println("Percorrendo a lista com foreach funcional");
		frutas.forEach(System.out::println);

		System.out.println("\nPercorrendo a coleção com iterator");
		Iterator<String> iterator = frutas.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
