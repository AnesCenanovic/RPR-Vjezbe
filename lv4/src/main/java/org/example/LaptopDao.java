package org.example;

public interface LaptopDao {

    public void dodajLaptopUListu (Laptop laptop);
    public void dodajLaptopUFile (Laptop laptop);
    public Laptop getLaptop(String procesor);
    public Laptop vratiPodatkeIzDatoteke();

}
