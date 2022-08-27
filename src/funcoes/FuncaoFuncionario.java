package funcoes;

import java.util.function.Function;

import dominio.Funcionario;

/*
 * Function é uma interface funcional que permite chamar um construtor com um argumento
 */
public class FuncaoFuncionario implements Function<String, Funcionario> {

	// apply cria um objeto usando o construtor de um argumento
	@Override
	public Funcionario apply(String nome) {
		return new Funcionario(nome);
	}

}
