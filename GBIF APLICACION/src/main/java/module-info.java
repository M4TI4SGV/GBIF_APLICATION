module com.example.gbifapliacacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gbifapliacacion to javafx.fxml;
    exports com.example.gbifapliacacion;
}