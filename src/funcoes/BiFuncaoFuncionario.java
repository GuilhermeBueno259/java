package funcoes;

import java.util.function.BiFunction;

import dominio.Funcionario;

/*
 * BiFunction é uma interface funcional que permite chamar um construtor de dois argumentos
 */
public class BiFuncaoFuncionario implements BiFunction<String, Integer, Funcionario> {

	// apply cria um objeto usando o contrutor de dois argumentos
	@Override
	public Funcionario apply(String nome, Integer idade) {
		return new Funcionario(nome, idade);
	}

}
