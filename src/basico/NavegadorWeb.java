package basico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class NavegadorWeb extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane painel = new AnchorPane();
		
		WebView web = new WebView();
		web.setPrefSize(1280, 800);
		web.getEngine().load("https://youtube.com");
		
		painel.getChildren().add(web);
		
		Scene cena = new Scene(painel);
		stage.setScene(cena);
		stage.setTitle("Meu navegador");
		stage.show();
	}

}
