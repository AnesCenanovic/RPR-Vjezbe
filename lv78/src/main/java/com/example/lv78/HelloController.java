package com.example.lv78;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
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

    private UserModel model;

    public HelloController(UserModel m) {
        this.model = m;

    }





    @FXML
    protected void initialize() {

        userListView.setItems(model.getUsers());
        imeField.textProperty().bindBidirectional(model.getTrenutniUser().imeProperty());
        prezimeField.textProperty().bindBidirectional(model.getTrenutniUser().prezimeProperty());
        emailField.textProperty().bindBidirectional(model.getTrenutniUser().emailProperty());
        korisnickoImeField.textProperty().bindBidirectional(model.getTrenutniUser().korisnickoImeProperty());
        passwordField.textProperty().bindBidirectional(model.getTrenutniUser().passwordProperty());

        userListView.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            System.out.println("Listener triggered. New User: " + newKorisnik);
            model.setTrenutniUser(newKorisnik);
            System.out.println("User ime: " + model.getTrenutniUser().getIme());
        });

        model.trenutniUserProperty().addListener((obs, oldUser, newUser) -> {
            if (oldUser != null) {
                System.out.println("Unbinding from: " + oldUser.getIme());
                imeField.textProperty().unbindBidirectional(oldUser.imeProperty() );
                prezimeField.textProperty().unbindBidirectional(oldUser.prezimeProperty() );
                emailField.textProperty().unbindBidirectional(oldUser.emailProperty() );
                korisnickoImeField.textProperty().unbindBidirectional(oldUser.korisnickoImeProperty() );
                passwordField.textProperty().unbindBidirectional(oldUser.passwordProperty() );
            }
            if (newUser == null) {
                clearInputFields();
            }
            else {
                System.out.println("Binding to: " + newUser.getIme());



                imeField.textProperty().bindBidirectional(newUser.imeProperty() );
                prezimeField.textProperty().bindBidirectional(newUser.prezimeProperty() );
                emailField.textProperty().bindBidirectional(newUser.emailProperty() );
                korisnickoImeField.textProperty().bindBidirectional(newUser.korisnickoImeProperty() );
                passwordField.textProperty().bindBidirectional(newUser.passwordProperty() );
            }
        });
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
            User newUser = new User(ime,prezime,email,korisnickoIme,password);
                model.addUser(newUser);
                model.setTrenutniUser(newUser);
                userListView.refresh();
                System.out.println(model.size());
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

