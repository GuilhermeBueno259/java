package collectors;

import java.util.ArrayList;
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


// devolve um ArrayList de Funcionario
public class Fornecedor implements Supplier<ArrayList<Funcionario>> {
	@Override
	public ArrayList<Funcionario> get() {
		return new ArrayList<Funcionario>();
	}
}
