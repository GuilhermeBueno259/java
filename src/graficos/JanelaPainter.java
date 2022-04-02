package graficos;

import javax.swing.*;

public class JanelaPainter extends JFrame {

	public JanelaPainter() {
		super("Painter Psicodélico usando modo gráfico");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setContentPane(new PainelPainter());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaPainter();

	}

}
