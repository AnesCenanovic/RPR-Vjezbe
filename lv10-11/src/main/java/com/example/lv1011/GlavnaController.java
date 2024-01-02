package com.example.lv1011;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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

        gradList.addAll(Grad.getGradList());

        tableView.setItems(gradList);
    }

    @FXML
    private void handleDodajGradButtonClick() {
        openAddForm("grad.fxml", "Dodaj Grad");
    }

    @FXML
    private void handleDodajDrzavuButtonClick() {
        openAddForm("drzava.fxml", "Dodaj Državu");
    }

    private void openAddForm(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            stage.setScene(new Scene(loader.load()));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}