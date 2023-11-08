package com.example.lv4;
import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file){
        this.file=file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop){
        this.laptopi = vratiPodatkeIzDatoteke(); // prvo vrati postojecu listu
        laptopi.add(laptop);
    }
    @Override
    public Laptop getLaptop(String procesor){
        this.laptopi = vratiPodatkeIzDatoteke();
        for(Laptop laptop: laptopi){
            if(laptop.getProcesor().equals(procesor)){
                return laptop;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke(){
        ArrayList<Laptop> result = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            result = (ArrayList<Laptop>) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException except){
            except.printStackTrace();
        }
        return result;
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop){
        this.laptopi = vratiPodatkeIzDatoteke(); // prvo vrati postojecu listu
        laptopi.add(laptop);
       // zapisi u datoteku
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
            outputStream.writeObject(laptopi);
        }
        catch (IOException except){
            except.printStackTrace();
        }
    }

}
