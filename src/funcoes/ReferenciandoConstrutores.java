package funcoes;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 * Podemos implementar as interfaces Supplier, Function e BiFunction através do Method Reference,
 * simplesmente referenciando o método construtor = Funcionario::new
 */
public class ReferenciandoConstrutores {
	public static void main(String[] args) {
		// construtor sem argumentos (construtor padrão) = usando Supplier
		Supplier<Funcionario> supplier = Funcionario::new; // cria um objeto Supplier
		Funcionario f1 = supplier.get();
		System.out.println(f1);
		// idem: Funcionario f1 = new Funcionario()
		
		// construtor com um argumento = usando Function
		Function<String, Funcionario> function = Funcionario::new; // cria um objeto Function
		Funcionario f2 = function.apply("Joao");
		System.out.println(f2);
		// idem: Funcionario f2 = new Funcionario("Joao")

		// construtor com dois argumentos = usando BiFunction
		BiFunction<String, Integer, Funcionario> biFunction = Funcionario::new; // cria um objeto BiFunction
		Funcionario f3 = biFunction.apply("Pedro", 32);
		System.out.println(f3);
		// idem: Funcionario f3 = new Funcionario("Pedro", 32)
	}
}
