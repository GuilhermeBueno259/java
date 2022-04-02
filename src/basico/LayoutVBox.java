package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutVBox extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox painel = new VBox();
		painel.setSpacing(20);
		painel.setAlignment(Pos.CENTER);
		
		Rectangle retanguloAzul = new Rectangle(100, 50);
		Rectangle retanguloVerde = new Rectangle(100, 50);
		Rectangle retanguloVermelho = new Rectangle(100, 50);
		
		retanguloAzul.setFill(Color.BLUE);
		retanguloVerde.setFill(Color.GREEN);
		retanguloVermelho.setFill(Color.RED);
		
		painel.getChildren().add(retanguloAzul);
		painel.getChildren().add(retanguloVerde);
		painel.getChildren().add(retanguloVermelho);
		
		Scene cena = new Scene(painel, 200, 250);
		stage.setTitle("Layout VBox");
		stage.setScene(cena);
		stage.show();
	}

}
