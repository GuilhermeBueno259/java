package collectors;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import dominio.Funcionario;

/*
 * classe java.util.Optional
 * foi criada para evitar verifica��es de extremos (null por exemplo)
 * cont�m vers�es primitivas: OptionalInt, OptionalLong, OptionalDouble
 */
public class ExemploOptional {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = List.of(
				new Funcionario(1, "Pedro Silva", 45),
				new Funcionario(2, "Antonio Moreira", 32),
				new Funcionario(3, "Marcos Oliveira", 42),
				new Funcionario(4, "Olivia Mendes", 29));

		// objetivo: calcula a m�dia das idades
		OptionalDouble media = funcionarios.stream()
										   .mapToInt(Funcionario::getIdade)
										   .average();

		System.out.println(media.orElse(0.0)); // devolve a m�dia ou 0.0
		
		// ou podemos lan�ar uma exce��o se o valor for 0.0
		double valorMedia = funcionarios.stream()
									    .mapToInt(Funcionario::getIdade)
									    .average()
									    .orElseThrow(IllegalStateException::new);
		
		System.out.println(valorMedia);
		
		// ou pedemos verificar se existe um valor dentro de Option
		funcionarios.stream()
 				    .mapToInt(Funcionario::getIdade)
				    .average()
				    .ifPresent(System.out::println); // s� imprime se existir o valor
	
		// obt�em o funcion�rio mais novo
		funcionarios.stream()
					.min(Comparator.comparing(Funcionario::getIdade))
					.ifPresent(f -> System.out.printf("\nIdade do funcion�rio mais novo: %d", f.getIdade()));
		
		// obt�m o funcion�rio mais velho
		funcionarios.stream()
					.max(Comparator.comparing(Funcionario::getIdade))
					.ifPresent(f -> System.out.printf("\nIdade do funcion�rio mais velho: %d", f.getIdade()));
	}
}
