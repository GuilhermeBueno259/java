package lambda_method;

import java.util.List;
import java.util.function.Consumer;

import dominio.Funcionario;

public class ExemploLambda1 {

	public static void main(String[] args) {
		Funcionario p1 = new Funcionario(1, "João da Silva", 22);
		Funcionario p2 = new Funcionario(2, "Alberto Roberto", 33);
		Funcionario p3 = new Funcionario(3, "Mariana Maria", 44);
		List<Funcionario> pessoas = List.of(p1, p2, p3);
		
		// 1
		for (int i=0; i<pessoas.size(); i++) {
			System.out.println(pessoas.get(i));
		}
		
		// 2
		System.out.println("\nCom foreach convencional");
		for (Funcionario p : pessoas) {
			System.out.println(p);
		}
		
		// 3
		System.out.println("\nCom foreach funcional e classe concreta");
		Consumer<Funcionario> consumidor = new Consumidor();
		pessoas.forEach(consumidor);
		
		// 4 
		System.out.println("\nCom foreach funcional e classe anônima");
		pessoas.forEach(new Consumer<Funcionario>() {

			@Override
			public void accept(Funcionario p) {
				System.out.println(p);
			}
		});
		
		// 5 
		/*
		 * O que é lambda no Java?
		 * Lambda é uma forma de representar uma classe anônima 
		 * que possua um único método (interface funcional)
		 */
		// Reescrevendo o código acima com lambda ->
		Consumer<Funcionario> consumidor2 = (Funcionario p) -> {
			System.out.println(p);
		};
		
		System.out.println("\nCom foreach funcional e lambda");
		pessoas.forEach(consumidor2);
		
		// 6
		// simplificando o código acima
		System.out.println("\nCom foreach funcional e lambda simplificado");
		pessoas.forEach(p -> System.out.println(p));

	}

}
