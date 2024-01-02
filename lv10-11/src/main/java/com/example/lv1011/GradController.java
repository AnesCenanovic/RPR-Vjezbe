package com.example.lv1011;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GradController {

    @FXML
    private TextField nazivTextField;

    @FXML
    private TextField brojStanovnikaTextField;

    @FXML
    private ChoiceBox<Drzava> drzavaChoiceBox;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private Grad grad;

    public void initialize() {
        drzavaChoiceBox.getItems().addAll(Drzava.getDrzavaList());
        drzavaChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleOkButtonClick() {
        String naziv = nazivTextField.getText();
        String brojStanovnikaString = brojStanovnikaTextField.getText();

        if (!naziv.isEmpty() && isNumeric(brojStanovnikaString)) {
            int brojStanovnika = Integer.parseInt(brojStanovnikaString);
            Drzava selectedDrzava = drzavaChoiceBox.getValue();
            grad = new Grad(1,naziv,brojStanovnika,selectedDrzava);
            closeStage();
        } else {
            // Handle invalid input
        }
    }
    @FXML
    private void handleCancelButtonClick() {
        grad = null; // Set grad to null to indicate cancellation
        closeStage();
    }
    public Grad getGrad() {
        return grad;
    }
    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
