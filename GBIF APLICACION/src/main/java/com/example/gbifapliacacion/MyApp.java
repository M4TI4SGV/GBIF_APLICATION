package com.example.gbifapliacacion;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {

    private Stage primaryStage;
    private BorderPane root;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Mi Aplicación");

        root = new BorderPane();
        showWelcomeScreen();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showWelcomeScreen() {
        root.getChildren().clear();

        // Logo de GBIF
        ImageView logoImageView = new ImageView(new Image("gbif_logo.png"));
        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        BorderPane.setAlignment(logoImageView, Pos.TOP_LEFT);
        root.setTop(logoImageView);

        // Texto de bienvenida
        Label welcomeLabel = new Label("La Global Biodiversity Information Facility es una organización internacional financiada por gobiernos de todo el mundo, destinada a proporcionar a cualquier persona, en cualquier lugar, acceso abierto y gratuito a datos sobre cualquier tipo de forma de vida que hay en la Tierra.");
        welcomeLabel.setWrapText(true);
        welcomeLabel.setAlignment(Pos.CENTER);
        VBox centerBox = new VBox(10, welcomeLabel);
        centerBox.setAlignment(Pos.CENTER);
        root.setCenter(centerBox);

        // Botón Consultar
        Button consultarButton = new Button("Consultar");
        consultarButton.setOnAction(e -> showQuerySelectionScreen());
        VBox bottomBox = new VBox(10, consultarButton);
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);
    }

    private void showQuerySelectionScreen() {
        root.getChildren().clear();

        // Logo de GBIF
        ImageView logoImageView = new ImageView(new Image("gbif_logo.png"));
        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        BorderPane.setAlignment(logoImageView, Pos.TOP_LEFT);
        root.setTop(logoImageView);

        // ListView de consultas predefinidas
        listView = new ListView<>();
        listView.getItems().addAll("Consulta 1", "Consulta 2", "Consulta 3");
        root.setCenter(listView);

        // Botón Atrás
        Button backButton = new Button("Atrás");
        backButton.setOnAction(e -> showWelcomeScreen());
        VBox bottomBox = new VBox(10, backButton);
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);
    }

    private void showResultScreen(String selectedQuery) {
        root.getChildren().clear();

        // Logo de GBIF
        ImageView logoImageView = new ImageView(new Image("gbif_logo.png"));
        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        BorderPane.setAlignment(logoImageView, Pos.TOP_LEFT);
        root.setTop(logoImageView);

        // Tablas de consulta seleccionada
        // Implementa aquí la lógica para mostrar las tablas según la consulta seleccionada

        // Botón Atrás
        Button backButton = new Button("Atrás");
        backButton.setOnAction(e -> showQuerySelectionScreen());
        VBox bottomBox = new VBox(10, backButton);
        bottomBox.setAlignment

                (Pos.CENTER);
        root.setBottom(bottomBox);
    }
}
