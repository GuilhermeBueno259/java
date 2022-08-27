package collectors;

import java.util.ArrayList;
import java.util.function.BiConsumer;

import dominio.Funcionario;

/*
 * ====> Adiciona apenas um objeto Funcionario à coleção
 * 
 * BiConsumer é uma interface funcional que contém o método accept()
 * que será invocado para adicionar cada elemento à lista passada.
 */
public class Acumulador implements BiConsumer<ArrayList<Funcionario>, Funcionario> {
	@Override
	public void accept(ArrayList<Funcionario> lista, Funcionario f) {
		lista.add(f);
	}
}
