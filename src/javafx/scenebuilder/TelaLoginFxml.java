package javafx.scenebuilder;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLoginFxml extends Application {

	protected static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		TelaLoginFxml.stage = stage;
//		Acha o arquivo dentro do projeto e retorna o caminho
		URL arquivoFxml = this.getClass().getResource("TelaLogin.fxml");
		
//		carrega o fxml dentro de um painel
		Parent painel = (Parent) FXMLLoader.load(arquivoFxml);
		
		stage.setScene(new Scene(painel));
		stage.setTitle("Login FXML");
		stage.show();
	}

}
