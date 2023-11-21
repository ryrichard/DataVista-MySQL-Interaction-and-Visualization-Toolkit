module com.example.colorsandshapes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires java.sql;

    opens com.example.colorsandshapes to javafx.fxml;
    exports com.example.colorsandshapes;
}