package com.example.lv78;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView<User> userListView;

    @FXML
    private TextField imeField;

    @FXML
    private TextField prezimeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField korisnickoImeField;

    @FXML
    private PasswordField passwordField;
    

    private SimpleStringProperty imeProperty = new SimpleStringProperty();
    private SimpleStringProperty prezimeProperty = new SimpleStringProperty();
    private SimpleStringProperty emailProperty = new SimpleStringProperty();
    private SimpleStringProperty korisnickoImeProperty = new SimpleStringProperty();
    private SimpleStringProperty passwordProperty = new SimpleStringProperty();

    public HelloController() {
         imeProperty = new SimpleStringProperty("");
         prezimeProperty = new SimpleStringProperty("");
         emailProperty = new SimpleStringProperty("");
         korisnickoImeProperty = new SimpleStringProperty("");
         passwordProperty = new SimpleStringProperty("");
    }

    public SimpleStringProperty imeProperty() {
        return  imeProperty;
    }
    public String getsImeProperty() {
        return  imeProperty.get();
    }
    public SimpleStringProperty prezimeProperty() {
        return  prezimeProperty;
    }
    public String getsPrezimeProperty() {
        return  prezimeProperty.get();
    }
    public SimpleStringProperty emailProperty() {
        return imeProperty;
    }
    public String getsEmailProperty() {
        return  emailProperty.get();
    }
    public SimpleStringProperty korisnickoImeProperty() {
        return  korisnickoImeProperty;
    }
    public String getsKorisnickoImeProperty() {
        return  korisnickoImeProperty.get();
    }
    public SimpleStringProperty passwordProperty() {
        return  passwordProperty;
    }
    public String getsPasswordProperty() {
        return  passwordProperty.get();
    }

    @FXML
    protected void initialize() {

        userListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                       User selectedUser = (User) newValue;
                        imeProperty.set(selectedUser.getIme());
                        prezimeProperty.set(selectedUser.getPrezime());
                        emailProperty.set(selectedUser.getEmail());
                        korisnickoImeProperty.set(selectedUser.getKorisnickoIme());
                        passwordProperty.set(selectedUser.getPassword());
                    }
                }
        );
        // Bind the text fields bidirectionally to the corresponding properties
        Bindings.bindBidirectional(imeField.textProperty(), imeProperty);
        Bindings.bindBidirectional(prezimeField.textProperty(), prezimeProperty);
        Bindings.bindBidirectional(emailField.textProperty(), emailProperty);
        Bindings.bindBidirectional(korisnickoImeField.textProperty(), korisnickoImeProperty);
        Bindings.bindBidirectional(passwordField.textProperty(), passwordProperty);
    }

    @FXML
    protected void onDodajButtonClick() {
        String ime = imeField.getText();
        String prezime = prezimeField.getText();
        String email = emailField.getText();
        String korisnickoIme = korisnickoImeField.getText();
        String password = passwordField.getText();

        // Check if all fields are filled
        if (!ime.isEmpty() && !prezime.isEmpty() && !email.isEmpty() && !korisnickoIme.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setIme(ime);
            user.setPrezime(prezime);
            user.setEmail(email);
            user.setKorisnickoIme(korisnickoIme);
            user.setPassword(password);
            userListView.getItems().add(user);
            clearInputFields();
        }
    }
        private void clearInputFields() {
            imeField.clear();
            prezimeField.clear();
            emailField.clear();
            korisnickoImeField.clear();
            passwordField.clear();
        }

    @FXML
    protected void onKrajButtonClick() {
        Platform.exit();
    }
    }

