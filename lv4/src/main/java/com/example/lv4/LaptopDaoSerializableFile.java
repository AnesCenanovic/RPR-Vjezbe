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
        if(laptopi.contains(laptop)==false){
            laptopi.add(laptop);
            dodajLaptopUFile(laptop);
        }
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

            try{
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                while(1==1){
                    try{
                        Object thing = inputStream.readObject();
                        if(thing instanceof Laptop){
                            Laptop thingy = (Laptop) thing;
                            result.add(thingy);
                        }
                        else{
                            for(Laptop laptop : (ArrayList<Laptop>) thing){
                                result.add(laptop);
                            }
                        }
                    }
                    catch (EOFException e) {
                        break;
                    }
                }
        }

        catch (IOException | ClassNotFoundException except){
            except.printStackTrace();
        }
        return result;
    }
    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop){
        this.laptopi = vratiPodatkeIzDatoteke(); // prvo vrati postojecu listu
        laptopi.add(laptop);
       // zapisi u datoteku
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(laptopi);
            outputStream.close();
        }
        catch (IOException except){
            except.printStackTrace();
        }
    }
}
