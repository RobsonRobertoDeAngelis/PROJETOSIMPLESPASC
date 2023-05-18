package br.com.importar.dados;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportarExportarBD<PreparedStatement> extends Application {

    private static final String DB_URL = "jdbc:sqlite:path/to/database.db";

    private TextArea logTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Importar e exportar App");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));

        Button importButton = new Button("Importar CSV");
        importButton.setOnAction(e -> importCSV());

        Button exportButton = new Button("Exportar para SQLite");
        exportButton.setOnAction(e -> exportToSQLite());

        logTextArea = new TextArea();
        logTextArea.setEditable(false);

        vbox.getChildren().addAll(importButton, exportButton, logTextArea);

        Scene scene = new Scene(vbox, 800, 600,Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void importCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Processe cada linha do arquivo CSV e salve-o no banco de dados
                    saveToDatabase(line);
                }
                log("CSV importação com sucesso.");
            } catch (Exception e) {
                log("Erro de importação CSV: " + e.getMessage());
            }
        }
    }

    private void saveToDatabase(String data) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             java.sql.PreparedStatement stmt = conn.prepareStatement("INSERT INTO tabela_nome (coluna_nome) VALUES (?)")) {
            stmt.setString(1, data);
            stmt.executeUpdate();
        }
    }

    private void exportToSQLite() {
        // Implemente sua lógica de exportação aqui
        log("A exportação para SQLite ainda não está implementada.");
    }

    private void log(String message) {
        logTextArea.appendText(message + "\n");
    }
}

