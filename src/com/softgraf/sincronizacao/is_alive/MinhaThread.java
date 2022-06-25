package com.softgraf.sincronizacao.is_alive;

// Exemplo de uso do método isAlive()
public class MinhaThread extends Thread {

	private String nome;

	public MinhaThread(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("\nRodando thread " + nome + " - contador = " + 1);
				Thread.sleep(1000); // dorme 1 segundo
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nThread " + nome + " finalizou");
	}

	public static void main(String[] args) {
		Thread t1 = new MinhaThread("T1");
		Thread t2 = new MinhaThread("T2");
		Thread t3 = new MinhaThread("T3");

		System.out.println("Iniciando Threads...");

		t1.start();
		t2.start();
		t3.start();

		do {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (t1.isAlive() || t2.isAlive() || t3.isAlive());

		// Se executada lança uma Exceção do Tipo IllegalThreadStateException
		//		t1.start();

	}

}
