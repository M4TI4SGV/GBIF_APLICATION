package com.example.gbifapliacacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@orion.javeriana.edu.co:1521/LAB"; // Reemplaza con tu URL de conexión
    private static final String USERNAME = "is294810"; // Reemplaza con tu nombre de usuario
    private static final String PASSWORD = "Jave2023*"; // Reemplaza con tu contraseña

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
        int x=1;
         return x;
    }

    // Aquí puedes agregar otros métodos para realizar operaciones en la base de datos, como ejecutar consultas, insertar registros, etc.
}
