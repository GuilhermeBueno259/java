package com.softgraf.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL FXML = this.getClass().getResource("/com/softgraf/view/TelaCalc.fxml");

		Parent painel = (Parent) FXMLLoader.load(FXML);

		stage.setScene(new Scene(painel));
		stage.setTitle("Calculadora FX");
		stage.setResizable(false);
		stage.show();
	}
}
