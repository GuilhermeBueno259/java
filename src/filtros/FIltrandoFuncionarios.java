package filtros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import dominio.Funcionario;

public class FIltrandoFuncionarios {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(1, "Pedro", 34, 8000f);
		Funcionario f2 = new Funcionario(2, "Mario", 23, 4300f);
		Funcionario f3 = new Funcionario(3, "Jose", 56, 1000f);
		Funcionario f4 = new Funcionario(4, "Leticia", 18, 10000f);
		Funcionario f5 = new Funcionario(5, "Alex", 31, 500f);
		Funcionario f6 = new Funcionario(6, "Maria", 32, 2000f);
		Funcionario f7 = new Funcionario(7, "Joao", 25, 4500f);

		// Cria lista imutável
		List<Funcionario> funcionarios = List.of(f1, f2, f3, f4, f5, f6, f7);

		System.out.println("\nLimitando a quantidade");
		funcionarios.stream()						// Stream permite concatenar métodos
					.limit(3)
					.forEach(System.out::println);	// Consumer e Method Reference

		System.out.println("\nFiltrando por idade");
		funcionarios.stream()
					.filter(f -> f.getIdade() >= 18)
					.forEach(System.out::println);
		
		System.out.println("\nFiltrando por salário: acima de R$ 3.000,00");
		funcionarios.stream()
					.filter(f -> f.getSalario() > 3000)
					.forEach(System.out::println);
		
		System.out.println("\nRemovendo os maiores de idade");
		List<Funcionario> soMenores = new ArrayList<>(funcionarios);
		soMenores.removeIf(f -> f.getIdade() >= 18);
		soMenores.forEach(System.out::println);

		// map() executa uma função para cada elemento da lista

		System.out.println("\nExemplo Map e Function");
		funcionarios.stream()
					.map(f -> f.getNome().toUpperCase())
					.forEach(System.out::println);

		System.out.println("\nObtém somente as idades com o map");
		funcionarios.stream()
					.map(f -> f.getIdade())
					.forEach(System.out::println);

		System.out.println("\nObtém somente as idades com o mapToInt");
		funcionarios.stream()
					.mapToInt(f -> f.getIdade())
					.forEach(System.out::println);

		System.out.println("\nAcha a menor idade");
		int menorIdade = funcionarios.stream()
					.mapToInt(Funcionario::getIdade)
					.min()
					.getAsInt();
		System.out.println(menorIdade);

		System.out.println("\nAcha a maior idade");
		int maiorIdade = funcionarios.stream()
					.mapToInt(Funcionario::getIdade)
					.max()
					.getAsInt();
		System.out.println(maiorIdade);

		System.out.println("\nMédia das idades");
		double mediaIdades = funcionarios.stream()
					.mapToInt(Funcionario::getIdade)
					.average()
					.getAsDouble();
		System.out.printf("%.2f", mediaIdades);

		System.out.println("\nMédia dos salarios");
		double mediaSalarios = funcionarios.stream()
				.mapToDouble(Funcionario::getSalario)
				.average()
				.getAsDouble();
		System.out.printf("R$ %.2f\n", mediaSalarios);

		System.out.println("\nOrdenando por idade:");
		funcionarios.stream()
					.sorted(Comparator.comparingInt(Funcionario::getIdade))
					.forEach(System.out::println);

		System.out.println("\nOrdenando por idade:");
		funcionarios.stream()
					.sorted(Comparator.comparingInt(Funcionario::getIdade).reversed())
					.forEach(System.out::println);

		System.out.println("\nMenor salario:");
		double menorSalario = funcionarios.stream()
					.mapToDouble(Funcionario::getSalario)
					.min()
					.getAsDouble();
		System.out.printf("R$ %.2f\n", menorSalario);
		
		System.out.println("\nSoma dos salarios:");
		double somaSalarios = funcionarios.stream()
					.mapToDouble(Funcionario::getSalario)
					.sum();
		System.out.printf("R$ %.2f\n", somaSalarios);
		
		System.out.println("\nIdade entre 18 e 50 anos");
		funcionarios.stream()
					.filter(f -> f.getIdade() >= 18 && f.getIdade() <= 50)
					.forEach(System.out::println);

		System.out.println("\nSalario entre 3000 e 9000 e idade entre 18 e 50 anos");
		funcionarios.stream()
					.filter(f -> (f.getIdade() >= 18 && f.getIdade() <= 50) && (f.getSalario() >= 3000 && f.getSalario() <= 9000))
					.forEach(System.out::println);
		
		System.out.println("\nFiltrando os nomes que iniciam com a letra A");
		funcionarios.stream()
					.filter(f -> f.getNome().toUpperCase().startsWith("A"))
					.forEach(System.out::println);
		
		System.out.println("\nFiltrando os nomes que terminam em el");
		funcionarios.stream()
					.filter(f -> f.getNome().toLowerCase().endsWith("el"))
					.forEach(System.out::println);
		
		System.out.println("\nFiltrando nomes com multiplos predicados");
		Predicate<Funcionario> iniciaComP = f -> f.getNome().toUpperCase().startsWith("P");
		Predicate<Funcionario> iniciaComM = f -> f.getNome().toUpperCase().startsWith("M");
		Predicate<Funcionario> iniciaComL = f -> f.getNome().toUpperCase().startsWith("L");
		Predicate<Funcionario> naoTemJ = f -> !f.getNome().toUpperCase().contains("J");
		Predicate<Funcionario> predicadoComplexo = iniciaComM.or(iniciaComL).or(iniciaComP).and(naoTemJ);
		
		funcionarios.stream()
					.filter(predicadoComplexo)
					.forEach(System.out::println);
		
		System.out.println("\nFIltrando salarios com multiplos predicados");
		Predicate<Funcionario> salMenorQue2000 = f -> f.getSalario() < 2000;
		Predicate<Funcionario> salMaiorQue10000 = f -> f.getSalario() > 10000;

		funcionarios.stream()
					.filter(salMenorQue2000.or(salMaiorQue10000))
					.forEach(System.out::println);
		
		System.out.println("\nFiltrando salarios com multiplos predicados (and)");
		Predicate<Funcionario> salEntre2000= f -> f.getSalario() >= 2000;
		Predicate<Funcionario> salEntre10000 = f -> f.getSalario() <= 10000;

		funcionarios.stream()
					.filter(salEntre2000.and(salEntre10000))
					.forEach(System.out::println);

	}
}
