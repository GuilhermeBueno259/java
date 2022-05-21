package com.softgraf.thread_heranca;

/*
 * Thread é uma classe Java que permite processamento concorrente, ou seja, consigo rodar multiplas classes ao mesmo tempo em um ou mais processadores.
 * 
 * Há duas formas de implementar Thread em Java:
 * 1. Através do processo de herança: estendendo a classe Thread do Java e sobrescrevendo o método run()
 * 	Principal problema da herança de Thread:
 * 	Se precisarmos, não podemos estender outra classe
 * 2. Através da implementação da interface Runnable do Java: criamos uma classe qualquer e implementamos Runnable sobrescrevendo o método run()
 * 
 * Neste exemplo estendemos a classe Thread, sobrescrevendo o método run()
 * e depois executamos run() chamando o método start()
 *  
 *  Alguns métodos herdados da classe Thread:
 *  - run() serve apenas para sobrescrita, nunca é chamado diretamente
 *  - start() é através dele que é chamado o método run()
 *  - sleep() suspende a thread por um intervalo de tempo dado em milissegundos
 *  - setName() defina o nome da Thread
 *  - currentThread() retorna a Thread em execução no exato momento
 *  
 *  Importante: mesmo iniciando threads em sequência, nunca sabemos qual vai ser a ordem exata de execução, mas podemos definir prioridades
 *  
 *  Em qualquer programa Java, temos pelo menos 2 threads em execução:
 *  - O método main(), com alta prioridade
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
