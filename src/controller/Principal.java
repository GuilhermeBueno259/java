package controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL fxml = this.getClass().getResource("/view/Tela.fxml");
		Parent painel = (Parent) FXMLLoader.load(fxml);
		
		stage.setScene(new Scene(painel));
		stage.setTitle("Cadastro Aluno");
		stage.setResizable(false);
		
		stage.show();
	}

}
