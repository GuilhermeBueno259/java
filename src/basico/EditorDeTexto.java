package basico;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditorDeTexto extends Application {

	private MenuBar barra;
	private Menu menuArquivo, menuEditar;
	private MenuItem itemNovo, itemAbrir, itemSalvar, itemSair, itemCopiar, itemColar;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane painel = new BorderPane();
		painel.setPrefSize(800, 600);

		barra = new MenuBar();
		painel.setTop(barra);

		menuArquivo = new Menu("Arquivo");
		menuEditar = new Menu("Editar");

		barra.getMenus().addAll(menuArquivo, menuEditar);

		itemAbrir = new MenuItem("Abrir");
		itemColar = new MenuItem("Colar");
		itemCopiar = new MenuItem("Copiar");
		itemNovo = new MenuItem("Novo");
		itemSair = new MenuItem("Sair");
		itemSalvar = new MenuItem("Salvar");

		menuArquivo.getItems().addAll(itemNovo, itemAbrir, itemSalvar, itemSair);
		menuEditar.getItems().addAll(itemCopiar, itemColar);

		itemSair.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Alert dialogo = new Alert(AlertType.CONFIRMATION);
				dialogo.setHeaderText(null);
				dialogo.setContentText("Você deseja realmente sair do programa?");
				Optional<ButtonType> retorno = dialogo.showAndWait();
				if (retorno.get() == ButtonType.OK)
					Platform.exit();
			}
		});

		Scene cena = new Scene(painel);
		stage.setTitle("Editor de Texto");
		stage.setScene(cena);
		stage.show();

	}

}
