package com.softgraf.thread_heranca;

/*
 * Thread � uma classe Java que permite processamento concorrente, ou seja, consigo rodar multiplas classes ao mesmo tempo em um ou mais processadores.
 * 
 * H� duas formas de implementar Thread em Java:
 * 1. Atrav�s do processo de heran�a: estendendo a classe Thread do Java e sobrescrevendo o m�todo run()
 * 	Principal problema da heran�a de Thread:
 * 	Se precisarmos, n�o podemos estender outra classe
 * 2. Atrav�s da implementa��o da interface Runnable do Java: criamos uma classe qualquer e implementamos Runnable sobrescrevendo o m�todo run()
 * 
 * Neste exemplo estendemos a classe Thread, sobrescrevendo o m�todo run()
 * e depois executamos run() chamando o m�todo start()
 *  
 *  Alguns m�todos herdados da classe Thread:
 *  - run() serve apenas para sobrescrita, nunca � chamado diretamente
 *  - start() � atrav�s dele que � chamado o m�todo run()
 *  - sleep() suspende a thread por um intervalo de tempo dado em milissegundos
 *  - setName() defina o nome da Thread
 *  - currentThread() retorna a Thread em execu��o no exato momento
 *  
 *  Importante: mesmo iniciando threads em sequ�ncia, nunca sabemos qual vai ser a ordem exata de execu��o, mas podemos definir prioridades
 *  
 *  Em qualquer programa Java, temos pelo menos 2 threads em execu��o:
 *  - O m�todo main(), com alta prioridade
 *  - GC - O Garbage Collector (DAEMON) -> coletor de lixo do Java, com baixa prioridade
 */

public class MinhaThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread: " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
