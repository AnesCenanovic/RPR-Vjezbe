package com.example.lv1011;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GradController {

    @FXML
    private TextField nazivTextField;

    private SimpleStringProperty naziv;

    @FXML
    private TextField brojStanovnikaTextField;

    private SimpleStringProperty brojStanovnika;

    @FXML
    private ChoiceBox<Drzava> drzavaChoiceBox;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private Grad grad;

    public GradController() {
        naziv = new SimpleStringProperty("");
        brojStanovnika = new SimpleStringProperty("");
    }

    public void initialize() {
        drzavaChoiceBox.getItems().addAll(Drzava.getDrzavaList());
        drzavaChoiceBox.getSelectionModel().selectFirst();

        nazivTextField.textProperty().bindBidirectional(naziv);
        brojStanovnikaTextField.textProperty().bindBidirectional(brojStanovnika);
    }

    @FXML
    private void handleOkButtonClick() {
        String naziv = nazivTextField.getText();
        String brojStanovnikaString = brojStanovnikaTextField.getText();

        if (!naziv.isEmpty() && isNumeric(brojStanovnikaString)) {
            int brojStanovnika = Integer.parseInt(brojStanovnikaString);
            Drzava selectedDrzava = drzavaChoiceBox.getValue();

            if (grad != null) {
                // If grad is not null, we are editing an existing instance
                grad.setNaziv(naziv);
                grad.setBrojStanovnika(brojStanovnika);
                grad.setDrzava(selectedDrzava);
            } else {
                // grad is null, so we are adding a new instance
                grad = new Grad(1, naziv, brojStanovnika, selectedDrzava);
            }

            closeStage();
        } else {
            // Handle invalid input
        }
    }

    @FXML
    private void handleCancelButtonClick() {
        grad = null;
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

    public void initializeWithGrad(Grad gradEdit) {
        // Initialize the form fields with data from the provided Grad instance
        nazivTextField.setText(gradEdit.getNaziv());
        brojStanovnikaTextField.setText(String.valueOf(gradEdit.getBrojStanovnika()));
        drzavaChoiceBox.setValue(gradEdit.getDrzava());
        grad = gradEdit;
    }

}
