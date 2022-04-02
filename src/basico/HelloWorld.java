package basico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		// chama o método start do JavaFX
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// elemento pai com layout de pilha
		StackPane painel = new StackPane();
		
		// texto
		Label lblMensagem = new Label("Olá Mundo! Bem-vindo ao JavaFX!");
		
		// recupera os filhos do painel e depois adiciona o label
		painel.getChildren().add(lblMensagem);
		
		// tamanho da cena
		Scene cena = new Scene(painel, 250, 100);
		stage.setTitle("Tela com JavaFX");
		stage.setScene(cena); // guarda a cena no stage
		stage.show();
	}

}
