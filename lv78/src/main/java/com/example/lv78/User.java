package com.example.lv78;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class User {
    private  StringProperty ime;
    private  StringProperty prezime;
    private  StringProperty email;
    private  StringProperty korisnickoIme;
    private  StringProperty password;

    // Constructor
    public User() {
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.korisnickoIme = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public User(String ime,String prezime,String email, String korisnickoIme, String password) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.password = new SimpleStringProperty(password);
    }
        // Getter and setter methods for ime
        public String getIme() {
            return ime.get();
        }

        public void setIme(String ime) {
            this.ime.set(ime);
        }

        public StringProperty imeProperty() {
            return ime;
        }

        // Getter and setter methods for prezime
        public String getPrezime() {
            return prezime.get();
        }

        public void setPrezime(String prezime) {
            this.prezime.set(prezime);
        }

        public StringProperty prezimeProperty() {
            return prezime;
        }

        // Getter and setter methods for email
        public String getEmail() {
            return email.get();
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public StringProperty emailProperty() {
            return email;
        }

        // Getter and setter methods for korisnickoIme
        public String getKorisnickoIme() {
            return korisnickoIme.get();
        }

        public void setKorisnickoIme(String korisnickoIme) {
            this.korisnickoIme.set(korisnickoIme);
        }

        public StringProperty korisnickoImeProperty() {
            return korisnickoIme;
        }

        // Getter and setter methods for password
        public String getPassword() {
            return password.get();
        }

        public void setPassword(String password) {
            this.password.set(password);
        }

        public StringProperty passwordProperty() {
            return password;
        }

        // Override toString() to customize the representation
        @Override
        public String toString() {
            return String.format("%s %s", getIme(), getPrezime());
        }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(getIme(), other.getIme())
                && Objects.equals(getPrezime(), other.getPrezime())
                && Objects.equals(getEmail(), other.getEmail())
                && Objects.equals(getKorisnickoIme(), other.getKorisnickoIme())
                && Objects.equals(getPassword(), other.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIme(), getPrezime(), getEmail(), getKorisnickoIme(), getPassword());
    }

    }

