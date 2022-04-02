package javafx.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleApp {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnOk;

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtSenha;

	@FXML
	void acaoCancelar(ActionEvent event) {
		TelaLoginFxml.stage.close();
	}

	@FXML
	void acaoOk(ActionEvent event) {
		Alert dlg;

		if (txtLogin.getText().equalsIgnoreCase("Guilherme") && txtSenha.getText().equalsIgnoreCase("qwerty")) {
			dlg = new Alert(AlertType.INFORMATION);
			dlg.setContentText("Login e Senha OK");
		} else {
			dlg = new Alert(AlertType.WARNING);
			dlg.setContentText("Login/Senha incorreto(s)!");
		}
		dlg.setTitle("Login");
		dlg.setHeaderText(null);
		dlg.showAndWait();
	}
}
