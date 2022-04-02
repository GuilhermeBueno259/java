package basico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerVideo extends Application {

	public static void main(String[] args) {
		System.out.println("Carregando áudio da web...");
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// carrega o clip de audio
		AudioClip audio = new AudioClip("https://softgraf.com/cursojava/multimidia/musica.wav");
		
		StackPane painel = new StackPane();
		painel.getChildren().add(new Text("Tocando Música..."));
		
		Scene cena = new Scene(painel);
		stage.setTitle("Player de Música");
		stage.setScene(cena);
		stage.show();
		
		// toca o audio
		audio.play();
	}
}
