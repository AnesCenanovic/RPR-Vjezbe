package com.example.lv1011;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DrzavaController {

    @FXML
    private TextField nazivTextField;

    private SimpleStringProperty naziv;

    @FXML
    private ChoiceBox<Grad> glavniGradChoiceBox;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private Drzava drzava;
    private ObservableList<Grad> gradovi = FXCollections.observableArrayList(GeografijaDAO.getInstance().gradovi());
    public DrzavaController() {
        naziv = new SimpleStringProperty("");
    }


    public void initialize() {
        glavniGradChoiceBox.setItems(gradovi);
        glavniGradChoiceBox.getSelectionModel().selectFirst();

        nazivTextField.textProperty().bindBidirectional(naziv);
    }

    @FXML
    private void handleOkButtonClick() {
        String naziv = nazivTextField.getText();
        Grad selectedGrad = glavniGradChoiceBox.getValue();

        if (!naziv.isEmpty() && selectedGrad != null) {

            drzava = new Drzava(1, naziv, selectedGrad);
            GeografijaDAO.getInstance().dodajDrzavu(drzava);
            closeStage();
        } else {
            // Handle invalid input
        }
    }

    @FXML
    private void handleCancelButtonClick() {
        drzava = null;
        closeStage();
    }

    public Drzava getDrzava() {
        return drzava;
    }

    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
