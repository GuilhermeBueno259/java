package com.bate_papo.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Classe responsável por enviar mensagens
 *
 */
public class BatePapo {

	public static void main(String[] args) {
		// Verifica se o usuário informou o endereço e a porta de comunicação
		if (args.length != 2) {
			System.out.println("\nParâmetros incorretos!\nJava BatePapo <endereco_multicast> <porta>");
			System.exit(1);
		}
		
		try {
			// Define o endereço de comunicação entre os sockets
			InetAddress endereco = InetAddress.getByName(args[0]);
			// Define a porta de comunicação
			int porta = Integer.parseInt(args[1]);
			
			// Cria um buffer de leitura do teclado
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite seu nome: ");
			String usuario = br.readLine();
			
			// Cria uma thread para responder às mensagens, até que o usuário digite "sair"
			BatepapoThread bp = new BatepapoThread(usuario, endereco, porta);
			// Inicia a execução da thread (que ficará aguardando)
			bp.start();
			
			// Cria um socket multicast para comunicação
			MulticastSocket socket = new MulticastSocket();
			// Para receber e enviar pacotes neste endereço e porta para multiplos usuarios
			socket.joinGroup(endereco);
			
			// executa "infinitamente" até digitar "sair"
			while (true) {
				System.out.println("Digite uma mensagem: ");
				String mensagem = br.readLine();
					
				// Se digitar "sair" encerra o programa
				if (mensagem.equals("sair")) {
					System.out.println("Fui!");
					System.exit(0);
				} else {
					// Cria uma mensagem
					mensagem = usuario + " diz " + mensagem;
					// usa um vetor de bytes para armazenar a mensagem
					byte[] msg = mensagem.getBytes();
					// O datagrama é o "envelope" por onde a mensagem será enviada
					DatagramPacket datagrama = new DatagramPacket(msg, msg.length, endereco, porta);
					// usa o socket multicast para enviar o datagrama
					socket.send(datagrama);
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
