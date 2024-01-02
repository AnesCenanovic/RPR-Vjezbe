package com.example.lv1011;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GlavnaController {

    @FXML
    private TableView<Grad> tableView;

    @FXML
    private Button dodajGradButton;
    @FXML
    private Button dodajDrzavuButton;
    @FXML
    private Button izmijeniGradButton;
    @FXML
    private Button obrisiGradButton;

    @FXML
    private TableColumn<Grad, Integer> idColumn;
    @FXML
    private TableColumn<Grad, String> nazivColumn;
    @FXML
    private TableColumn<Grad, Integer> stanovnikaColumn;
    @FXML
    private TableColumn<Grad, Drzava> drzavaColumn;

    private final ObservableList<Grad> gradList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nazivColumn.setCellValueFactory(cellData -> cellData.getValue().nazivProperty());
        stanovnikaColumn.setCellValueFactory(cellData -> cellData.getValue().brojStanovnikaProperty().asObject());
        drzavaColumn.setCellValueFactory(cellData -> cellData.getValue().drzavaProperty());

        gradList.setAll(Grad.getGradList());

        tableView.setItems(gradList);
    }

}