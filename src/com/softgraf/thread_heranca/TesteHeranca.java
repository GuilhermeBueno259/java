package com.softgraf.thread_heranca;

public class TesteHeranca {

	public static void main(String[] args) {
		Thread t1 = new MinhaThread();
		t1.setName("Thread A");
		t1.start();
		
		Thread t2 = new MinhaThread();
		t2.setName("Thread B");
		t2.start();
		
		System.out.println("Iniciou");
	}

}
