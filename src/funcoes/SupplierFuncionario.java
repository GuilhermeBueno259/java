package funcoes;

// o pacote java.util.function contém interfaces funcionais
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 * Conceito Factory
 * O que é um factory?
 * É um design pattern (padrão de projeto)
 * é uma fábrica de objetos, ou seja, uma classe com
 * um método quee instancia e retorna determinado objeto.
 * 
 * Supplier cria um objjeto através do construtor padrão do objeto (sem argumentos).
 * Supplier é uma interface funcional com um único métoddo: get()
 */
public class SupplierFuncionario implements Supplier<Funcionario> {

	// getcria um objeto usando o construtor sem argumentos
	@Override
	public Funcionario get() {
		return new Funcionario();
	}

}
