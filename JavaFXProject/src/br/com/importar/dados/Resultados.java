package br.com.importar.dados;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Resultados extends Application {

	@Override
	public void start(Stage primeiraScena) throws Exception {
		
		StackPane root = new StackPane();
		
		Scene scene = new Scene(root, 800, 600, Color.BEIGE);
		
		primeiraScena.setTitle("Resultado CSV");
		primeiraScena.setScene(scene);
		primeiraScena.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}