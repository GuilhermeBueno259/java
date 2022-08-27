package predicado;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import dominio.Funcionario;

//A interface funcional Predicate possiu um único método abstrato test() que retorna um boolean
//e possui os métodos default: and, or, negate, isEqual, not
//Um predicado sempre retorna true ou false
public class ExemploPredicado {
	public static void main(String[] args) {
		Predicate<Integer> menorQue18 = i -> i < 18;
		System.out.println(menorQue18.test(10));
		System.out.println(menorQue18.test(18));

		Predicate<Integer> maiorQue10 = i -> i > 10;
		Predicate<Integer> menorQue20 = i -> i < 20;

		// retorna true retorna se for maior que 10 e menor que 20
		boolean resultado = maiorQue10.and(menorQue20).test(15);
		System.out.println(resultado);

		// retorna true retorna se não for maior que 10 e menor que 20
		boolean resultado2 = maiorQue10.and(menorQue20).negate().test(15);
		System.out.println(resultado2);

		Funcionario f1 = new Funcionario(1, "Alberto Roberto", 33);
		Predicate<Funcionario> funcMaior18 = f -> f.getIdade() >= 18;
		Predicate<Funcionario> funcMenor60 = f -> f.getIdade() <= 60;
		boolean trabalha = funcMaior18.and(funcMenor60).test(f1);
		System.out.println(trabalha ? "É um trabalhador" : "É menor ou aposentado");

		// Predicado com dois argumeentos
		BiPredicate<String, Integer> seTamanhoValido = (palavra, tamanho) -> palavra.length() >= tamanho;

		boolean palavra1 = seTamanhoValido.test("Lucas", 4);
		System.out.println(palavra1);

		boolean palavra2 = seTamanhoValido.test("Antonela", 7);
		System.out.println(palavra2);
	}
}
