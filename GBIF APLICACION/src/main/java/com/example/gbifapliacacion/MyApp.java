package com.example.gbifapliacacion;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {

    private Stage primaryStage;
    private BorderPane root;
    private DatabaseManager databaseManager;

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

        // Crear instancia de DatabaseManager
        databaseManager = new DatabaseManager();
        testConnection();
    }

    private void showWelcomeScreen() {
        // ... código de la primera pantalla
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
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Consulta 1", "Consulta 2", "Consulta 3");
        root.setCenter(listView);

        // Agregar evento de clic a la ListView
        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                    showResultScreen(selectedItem);

            }
        });

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

        if (selectedQuery.equalsIgnoreCase("Consulta 1")){

            Label welcomeLabel = new Label("Consulta 1 - resultado");
            welcomeLabel.setWrapText(true);
            welcomeLabel.setAlignment(Pos.TOP_CENTER);
            VBox centerBox = new VBox(10, welcomeLabel);
            centerBox.setAlignment(Pos.TOP_CENTER);
            root.setCenter(centerBox);

            TableView<ObservableList<Object>> tableView  = (TableView<ObservableList<Object>>) databaseManager.getConnection();
            root.setCenter(tableView);


        } else if (selectedQuery.equalsIgnoreCase("Consulta 2")){
            Label welcomeLabel = new Label("Consulta 2 - resultado");
            welcomeLabel.setWrapText(true);
            welcomeLabel.setAlignment(Pos.TOP_CENTER);
            VBox centerBox = new VBox(10, welcomeLabel);
            centerBox.setAlignment(Pos.TOP_CENTER);
            root.setCenter(centerBox);
        } else if (selectedQuery.equalsIgnoreCase("Consulta 3")){
            Label welcomeLabel = new Label("Consulta 3 - resultado");
            welcomeLabel.setWrapText(true);
            welcomeLabel.setAlignment(Pos.TOP_CENTER);
            VBox centerBox = new VBox(10, welcomeLabel);
            centerBox.setAlignment(Pos.TOP_CENTER);
            root.setCenter(centerBox);

        }


        // Botón Atrás
        Button backButton = new Button("Atrás");
        backButton.setOnAction(e -> showQuerySelectionScreen());
        VBox bottomBox = new VBox(10, backButton);
        bottomBox.setAlignment

                (Pos.CENTER);
        root.setBottom(bottomBox);
    }

    private void testConnection() {
        if (databaseManager != null && databaseManager.getConnection() != null) {
            System.out.println("Conexión exitosa a la base de datos");
        } else {
            System.out.println("Error conexion");
        }
    }
}
