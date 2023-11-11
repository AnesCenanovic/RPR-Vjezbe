package com.example.lv4;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException{

        Laptop myLaptop = new Laptop("HP", "Pavilion", 899.99, 8, 1000, 256, "i5", "NVIDIA", 15.6);

        System.out.println(myLaptop.getRam());
        System.out.println(myLaptop.getProcesor());
        myLaptop.setRam(32);
        System.out.println(myLaptop.getRam());

        Laptop myLaptop1 = new Laptop("HP", "Pavilion", 999.99, 8, 1000, 256, "i5", "NVIDIA", 15.6);
        Laptop myLaptop2 = new Laptop("HP", "Pavilion", 799.99, 8, 1000, 256, "i5", "NVIDIA", 15.6);

        String fileName = "random.txt";
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        LaptopDaoSerializableFile laptop = new LaptopDaoSerializableFile(file);

        laptop.dodajLaptopUListu(myLaptop);
        laptop.dodajLaptopUListu(myLaptop1);
        laptop.dodajLaptopUListu(myLaptop2);

        System.out.println("Laptopi u TXTfile-u:");
        ArrayList<Laptop> laptop1 = laptop.vratiPodatkeIzDatoteke();
        for (Laptop thing : laptop1) {
            System.out.println(thing.getProcesor());
        }

        try {
            if (laptop1.isEmpty())
                throw  new Izuzetak("Lista nije prazna");
        }
        catch(Izuzetak poruka)
        {
            System.out.println("Izuzetak: " + poruka);
        }

        Laptop myLaptop3=laptop.getLaptop("i5");
        System.out.println("Procesor: " +  myLaptop3.getProcesor() + " Brend: " +  myLaptop3.getBrend() + " Model: " +  myLaptop3.getModel());

        // Isti princip testova za ostale formate fajlova

    }

}
