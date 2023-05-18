package br.com.importar.dados;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ImportarImprimir extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Cria uma instância do FileChooser
        FileChooser fileChooser = new FileChooser();

        // Define o título da janela de seleção de arquivo
        fileChooser.setTitle("Abrir Arquivo");

        // Define um filtro de extensão de arquivo (opcional)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Arquivos de Texto (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        // Cria um botão para a ação de impressão
        Button printButton = new Button("Imprimir");
        printButton.setOnAction(event -> {
            // Mostra a caixa de diálogo de seleção de arquivo
            File arquivoSelecionado = fileChooser.showOpenDialog(primaryStage);

            // Verifica se o arquivo foi selecionado
            if (arquivoSelecionado != null) {
                try {
              
					// Lê o conteúdo do arquivo
                    String conteudo = Files.readString(arquivoSelecionado.toPath(), StandardCharsets.UTF_8);

                    // Cria um TextArea para exibir o conteúdo do arquivo
                    TextArea textArea = new TextArea(conteudo);

                    // Cria um layout de BorderPane e define o TextArea como o centro
                    BorderPane root = new BorderPane(textArea);

                    // Cria uma cena com o layout BorderPane
                    Scene scene = new Scene(root, 400, 300);

                    // Cria uma impressora virtual
                    PrinterJob printerJob = PrinterJob.createPrinterJob();

                    // Imprime o conteúdo do TextArea
                    if (printerJob != null && printerJob.showPrintDialog(primaryStage)) {
                        if (printerJob.printPage(textArea)) {
                            printerJob.endJob();
                        }
                    }

                    // Fecha o palco (stage)
                    primaryStage.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Cria um layout de BorderPane e define o botão como o centro
        BorderPane root = new BorderPane(printButton);

        // Cria uma cena com o layout BorderPane
        Scene scene = new Scene(root, 700, 600,Color.DARKBLUE);

        // Define a cena no palco (stage) e exibe o palco
        primaryStage.setScene(scene);
        primaryStage.setTitle("Imprimir Arquivo");
        primaryStage.show();
    }
}
