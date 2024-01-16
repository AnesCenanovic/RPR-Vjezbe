package com.example.lv1011;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Grad {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty naziv = new SimpleStringProperty();
    private final IntegerProperty brojStanovnika = new SimpleIntegerProperty();
    private final ObjectProperty<Drzava> drzava = new SimpleObjectProperty<>();



    // Constructors

    public Grad(int id, String naziv, int brojStanovnika, Drzava drzava){
        setId(id);
        setNaziv(naziv);
        setBrojStanovnika(brojStanovnika);
        setDrzava(drzava);

    }

    public Grad(){
    }

    // Getters

    public int getId() {
        return id.get();
    }

    public String getNaziv() {
        return naziv.get();
    }

    public int getBrojStanovnika() {
        return brojStanovnika.get();
    }

    public Drzava getDrzava() {
        return drzava.get();
    }

    // Setters

    public void setId(int id) {
        this.id.set(id);
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika.set(brojStanovnika);
    }

    // JavaFX property accessors

    public void setDrzava(Drzava drzava) {
        this.drzava.set(drzava);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public IntegerProperty brojStanovnikaProperty() {
        return brojStanovnika;
    }

    public ObjectProperty<Drzava> drzavaProperty() {
        return drzava;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
}
