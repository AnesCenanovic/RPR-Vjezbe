package com.example.lv1011;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Grad {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty naziv = new SimpleStringProperty();
    private final IntegerProperty brojStanovnika = new SimpleIntegerProperty();
    private final ObjectProperty<Drzava> drzava = new SimpleObjectProperty<>();

    private static final List<Grad> gradList = new ArrayList<>();

    static {
        new Grad(1, "Grad1", 100000, new Drzava(1, "Drzava1", null));
        new Grad(2, "Grad2", 150000, new Drzava(2, "Drzava2", null));
        new Grad(3, "Grad3", 250000, new Drzava(3, "Drzava3", null));
        new Grad(4, "Grad4", 350000, new Drzava(3, "Drzava3", null));
        new Grad(5, "Grad5", 450000, new Drzava(4, "Drzava4", null));

        // Add more predefined values as needed
    }

    // Constructors

    public Grad(int id, String naziv, int brojStanovnika, Drzava drzava){
        setId(id);
        setNaziv(naziv);
        setBrojStanovnika(brojStanovnika);
        setDrzava(drzava);
        gradList.add(this);
        System.out.println("Dodan");
        System.out.println(gradList.size());
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

    public static List<Grad> getGradList() {
        return gradList;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
}
