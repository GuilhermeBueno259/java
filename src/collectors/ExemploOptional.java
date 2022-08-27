package collectors;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import dominio.Funcionario;

/*
 * classe java.util.Optional
 * foi criada para evitar verificações de extremos (null por exemplo)
 * contém versões primitivas: OptionalInt, OptionalLong, OptionalDouble
 */
public class ExemploOptional {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = List.of(
				new Funcionario(1, "Pedro Silva", 45),
				new Funcionario(2, "Antonio Moreira", 32),
				new Funcionario(3, "Marcos Oliveira", 42),
				new Funcionario(4, "Olivia Mendes", 29));

		// objetivo: calcula a média das idades
		OptionalDouble media = funcionarios.stream()
										   .mapToInt(Funcionario::getIdade)
										   .average();

		System.out.println(media.orElse(0.0)); // devolve a média ou 0.0
		
		// ou podemos lançar uma exceção se o valor for 0.0
		double valorMedia = funcionarios.stream()
									    .mapToInt(Funcionario::getIdade)
									    .average()
									    .orElseThrow(IllegalStateException::new);
		
		System.out.println(valorMedia);
		
		// ou pedemos verificar se existe um valor dentro de Option
		funcionarios.stream()
 				    .mapToInt(Funcionario::getIdade)
				    .average()
				    .ifPresent(System.out::println); // só imprime se existir o valor
	
		// obtéem o funcionário mais novo
		funcionarios.stream()
					.min(Comparator.comparing(Funcionario::getIdade))
					.ifPresent(f -> System.out.printf("\nIdade do funcionário mais novo: %d", f.getIdade()));
		
		// obtém o funcionário mais velho
		funcionarios.stream()
					.max(Comparator.comparing(Funcionario::getIdade))
					.ifPresent(f -> System.out.printf("\nIdade do funcionário mais velho: %d", f.getIdade()));
	}
}
