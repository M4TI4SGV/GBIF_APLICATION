package com.example.gbifapliacacion;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@orion.javeriana.edu.co:1521/LAB"; // Reemplaza con tu URL de conexión
    private static final String USERNAME = "is294811"; // Reemplaza con tu nombre de usuario
    private static final String PASSWORD = "Sar.2o2e"; // Reemplaza con tu contraseña

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public Object getConnection() {
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT l.locationID, l.locationname, COUNT(*) AS organism_count " +
                    "FROM location l " +
                    "JOIN event e ON l.locationID = e.locationID " +
                    "WHERE e.eventType = 'image capture' " +
                    "GROUP BY l.locationID, l.locationname";

            ObservableList<ObservableList<Object>> data = FXCollections.observableArrayList();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                data.add(row);
            }
            TableView<ObservableList<Object>> tableView = new TableView<>();
            for (int i = 0; i < columnCount; i++) {
                final int columnIndex = i;
                TableColumn<ObservableList<Object>, Object> column = new TableColumn<>(metaData.getColumnLabel(i + 1));
                column.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().get(columnIndex)));
                tableView.getColumns().add(column);
            }
            tableView.setItems(data);
             return tableView;
            // Establecer los datos en la tabla


           //

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int x=1;
        return x;
    }

    // Aquí puedes agregar otros métodos para realizar operaciones en la base de datos, como ejecutar consultas, insertar registros, etc.
}
