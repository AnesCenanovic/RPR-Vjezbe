module com.example.rprt1z3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rprt1z3 to javafx.fxml;
    exports com.example.rprt1z3;
}