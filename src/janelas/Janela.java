package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela extends JFrame {

	private JButton button1;
	private JButton button2;
	private JLabel label1;

	public Janela() {
		setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Janela com Swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		label1 = new JLabel("Texto");
		JTextField textoTF1 = new JTextField("Texto do text field");

		button1.setSize(100, 327);
		button2.setSize(300, 334);
		label1.setSize(100, 50);
		textoTF1.setSize(100, 50);

		button1.setLocation(400, 200);
		button2.setLocation(50, 452);
		textoTF1.setLocation(100, 100);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(textoTF1.getText());
			}
		});
		
		add(button1);
		add(button2);
		add(label1);
		add(textoTF1);
	}

	public static void main(String[] args) {
		Janela janela = new Janela();
		janela.setVisible(true);
	}
}
