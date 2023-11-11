package com.example.lv4;
import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {

    public void dodajLaptopUListu (Laptop laptop) throws IOException;
    public void dodajLaptopUFile (Laptop laptop);
    public Laptop getLaptop(String procesor) throws IOException;
    public void napuniListu(ArrayList<Laptop> laptopi);
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException;

}

