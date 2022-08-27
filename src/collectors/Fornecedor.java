package collectors;

import java.util.ArrayList;
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 * Conceito Factory
 * O que � um factory?
 * � um design pattern (padr�o de projeto)
 * � uma f�brica de objetos, ou seja, uma classe com
 * um m�todo quee instancia e retorna determinado objeto.
 * 
 * Supplier cria um objjeto atrav�s do construtor padr�o do objeto (sem argumentos).
 * Supplier � uma interface funcional com um �nico m�toddo: get()
 */


// devolve um ArrayList de Funcionario
public class Fornecedor implements Supplier<ArrayList<Funcionario>> {
	@Override
	public ArrayList<Funcionario> get() {
		return new ArrayList<Funcionario>();
	}
}
