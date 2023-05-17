module com.example.gbifapliacacion {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.gbifapliacacion to javafx.fxml;
    exports com.example.gbifapliacacion;
}