package lambda_method;

import java.util.function.Consumer;

import dominio.Funcionario;

/*
 * O que é uma interface funcional?
 * Qualquer interface que possua um único método abstrato é chamado de interface funcional
 * Obs.: método marcaddos com a palavra reservada default, são métodos especiais e são
 * implementados unicamente dentro de interfaces, por isso não contam como método abstrato
 */

/*
 * Aqui temos a interface funcional Consumer que implementa o único méetoddo abstrato: accept()
 */
public class Consumidor implements Consumer<Funcionario> {

	@Override
	public void accept(Funcionario f) {
		System.out.println(f);
	}

}
