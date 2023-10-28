module com.example.zadatak3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadatak3 to javafx.fxml;
    exports com.example.zadatak3;
}