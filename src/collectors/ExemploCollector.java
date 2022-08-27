package collectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import dominio.Funcionario;

/*
 * Um Collector converte Stream em Collection, chamando o méetodo collect() do Stream
 * Collector é a junção de várias interfaces funcionais como: Supplier, BiConsumer, Function, etc
 */
public class ExemploCollector {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = List.of(
				new Funcionario(1, "Pedro Silva", 45),
				new Funcionario(2, "Antonio Moreira", 32),
				new Funcionario(3, "Marcos Oliveira", 42),
				new Funcionario(4, "Olivia Mendes", 29));

		// fornecedor é uma factory da classe Funcionario (fábrica de funcionários)
		Supplier<ArrayList<Funcionario>> fornecedor = ArrayList::new; // Method Reference

		// acumulador serve para dicionar cada elemento na coleção
		BiConsumer<ArrayList<Funcionario>, Funcionario> acumulador = ArrayList::add;

		// combinador serve para dicionar mais de um elemento ao mesmo tempo
		BiConsumer<ArrayList<Funcionario>, ArrayList<Funcionario>> combinador = ArrayList::addAll;

		// stream = pipeline
		List<Funcionario> maisDe30 = funcionarios.stream()
									.filter(f -> f.getIdade() > 30)
									.collect(fornecedor, acumulador, combinador);

		maisDe30.forEach(System.out::println);
		
		// ficou complicado, então vamos simplificar
		
		System.out.println("\nCollector simplificado devolvendo List");
		funcionarios.stream()
					.filter(f -> f.getIdade() > 30)
					.collect(Collectors.toList()) // retorna um collector parecido com o de cima
					.forEach(System.out::println);
		
		// tambéem podemos devolver um Set com Collector
		System.out.println("\nCollector devolvendo Set");
		funcionarios.stream()
					.filter(f -> f.getIdade() > 30)
					.collect(Collectors.toSet())
					.forEach(System.out::println);
		
		System.out.println("\nObtendo uma implementação de Collector");
		funcionarios.stream()
					.filter(f -> f.getIdade() > 30)
					.collect(Collectors.toCollection(HashSet::new))
					.forEach(System.out::println);
		
		System.out.println("\nCollection personalizada");
		Funcionario[] array = funcionarios.stream()
										  .filter(f -> f.getIdade() > 30)
										  .toArray(Funcionario[]::new);
		
		for (Funcionario funcionario : array) {
			System.out.println(funcionario);
		}
	}
}
