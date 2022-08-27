package predicado;

import java.util.function.Predicate;

import dominio.Funcionario;

// A interface funcional Predicate possiu um único método abstrato test() que retorna um boolean
// e possui os métodos default: and, or, negate, isEqual, not
// Um predicado sempre retorna true ou false
public class PredicadoFuncionario implements Predicate<Funcionario> {
	@Override
	public boolean test(Funcionario f) {
		return f.getIdade() >= 18;
	}
}
