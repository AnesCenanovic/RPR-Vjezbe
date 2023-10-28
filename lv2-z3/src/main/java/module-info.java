module com.example.lv2z3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lv2z3 to javafx.fxml;
    exports com.example.lv2z3;
}