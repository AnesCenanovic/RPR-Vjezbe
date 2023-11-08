package com.example.lv4;

import java.util.ArrayList;

public interface LaptopDao {

    public void dodajLaptopUListu (Laptop laptop);
    public void dodajLaptopUFile (Laptop laptop);
    public Laptop getLaptop(String procesor);
    public ArrayList<Laptop> vratiPodatkeIzDatoteke();

}

