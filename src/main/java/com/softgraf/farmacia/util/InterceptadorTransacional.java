package com.softgraf.farmacia.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 * A classe responsável pelas interceptações deve ser anotada com @Interceptor e @Transacional
 */

@Interceptor // especifica que uma classe é um interceptador
@Transacional
public class InterceptadorTransacional implements Serializable {
	private static final long serialVersionUID = -878489902366159151L;

	@Inject
	private EntityManager em;

	/*
	 * O método que fará as interceptações Transacionais precisa:
	 * - receber InvocationContext como parâmetro;
	 * - retornar um Object; - ele pode lançar uma Exception;
	 * - além de ser anotado com @AroundInvoke;
	 * - este método deve chamar (executar) contexto.proceed(), que faz com que o método interceptado seja realmente chamado.
	 */

	public Object invocar(InvocationContext contexto) throws Exception {
		EntityTransaction tx = em.getTransaction();
		boolean begin = false; // nenhuma transação iniciada pelo método invocar

		try {
			if (!tx.isActive()) { // se transação não ativa
				// truqque para executar rollback no que já passou, para que
				// um futuro commit não execute operações sem transação
				tx.begin();
				tx.rollback();

				// agora sim inicia a nova transação
				tx.begin();
				begin = true;
				System.out.println("\nIniciando a transação");
			}
			/*
			 * procede com a próxima etapa do processo de invocação. proceed() faz com que
			 * outro inteceptador seja invocado ou faz com que o objeto final seja invocado.
			 */

			return contexto.proceed();
		} catch (Exception e) {
			if (tx != null && begin) {
				tx.rollback();
				System.out.println("\nOcorreu um exceção durante a transação");
			}

			throw e;

		} finally {
			if (tx != null && tx.isActive() && begin) {
				tx.commit();
				System.out.println("\nFinalizando a transação");
			}
		}
		/*
		 * Agora precisamos registrar o interceptador, podemos fazer isso no arquivo beans.xml
		 */
	}
}
