package com.softgraf.relogio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaRelogio extends JFrame implements Runnable {

	private static final long serialVersionUID = 4449465731062643522L;

	private JLabel lblHora;
	private JButton btnIniciar, btnDormir, btnInterromper, btnFechar;
	private SimpleDateFormat formatador;
	private Thread relogio;

	public JanelaRelogio() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int largura = toolkit.getScreenSize().width; // Coloca a largura da tela dentro da variável largura
		setSize(new Dimension(220, 270));
		setLocation(largura - getWidth(), 0); // Posiciona a tela na coordenada indicada
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); // Remove controles
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f)); // Muda a opacidade do fundo

		lblHora = new JLabel("00:00:00");
		lblHora.setSize(new Dimension(150, 30));
		lblHora.setLocation(new Point(50, 20));
		lblHora.setFont(new Font(lblHora.getName(), Font.PLAIN, 30));
		add(lblHora);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setSize(new Dimension(150, 30));
		btnIniciar.setLocation(new Point(40, 70));
		btnIniciar.setFocusable(false);
		btnIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!relogio.isAlive()) {
					relogio.start();
				}
			}
		});
		add(btnIniciar);

		btnDormir = new JButton("Dormir");
		btnDormir.setSize(new Dimension(150, 30));
		btnDormir.setLocation(new Point(40, 110));
		btnDormir.setFocusable(false);
		btnDormir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					System.out.println("Thread interrompida (acordada)");
					e1.printStackTrace();
				}
			}
		});
		add(btnDormir);

		btnInterromper = new JButton("Interromper");
		btnInterromper.setSize(new Dimension(150, 30));
		btnInterromper.setLocation(new Point(40, 150));
		btnInterromper.setFocusable(false);
		btnInterromper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				relogio.interrupt();
			}
		});
		add(btnInterromper);

		btnFechar = new JButton("Fechar");
		btnFechar.setSize(new Dimension(150, 30));
		btnFechar.setLocation(new Point(40, 190));
		btnFechar.setFocusable(false);
		btnFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				dispose();
			}
		});
		add(btnFechar);

		formatador = new SimpleDateFormat("HH:mm:ss");
		relogio = new Thread(this);
	}

	@Override
	public void dispose() {
		System.out.println("Fechando...");
		relogio = null;
		super.dispose();
	}

	@Override
	public void run() {
		System.out.println("Running...");
		while (relogio != null) {
			try {
				atualizaHora();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				relogio = null;
			}
		}
	}

	private void atualizaHora() {
		String hora = formatador.format(new Date());
		this.lblHora.setText(hora);
	}

	public static void main(String[] args) {
		JFrame janela = new JanelaRelogio();
		janela.setVisible(true);
	}

}
