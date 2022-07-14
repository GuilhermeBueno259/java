package com.bate_papo.controle;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Essa classe é responsável por exibir as mensagens recebidas
 *
 */
public class BatepapoThread extends Thread {

	private String usuario;
	private InetAddress endereco;
	private int porta;

	public BatepapoThread(String usuario, InetAddress endereco, int porta) {
		super();
		this.usuario = usuario;
		this.endereco = endereco;
		this.porta = porta;
	}

	@Override
	public void run() {
		try {
			// socket para receber e enviar pacotes (datagramas) para múltiplos usuários
			MulticastSocket socket = new MulticastSocket(porta);
			// Passa a aceitar pacotes neste endereço e porta
			socket.joinGroup(endereco);

			// Executa infinitamente
			while (true) {
				// Cria um vetor para receber uma mensagem de até 128 bytes
				byte[] msg = new byte[128];
				// Cria um pacote para receber a mensagem
				DatagramPacket datagrama = new DatagramPacket(msg, msg.length);
				// Aguarda o envio da mensagem e armazena no datagrama
				socket.receive(datagrama);
				// O datagrama é desempacotado e convertido em string
				String mensagem = new String(datagrama.getData());
				// ATENÇÃO! não exibe mensagem se for do mesmo usuário (ou seja, da própria
				// máquina)
				if (!mensagem.contains(usuario)) {
					System.out.println("\nMensagem recebida: " + mensagem);
					System.out.println("Digite uma mensagem: ");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
