package com.example.lv4;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file){
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
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Laptop> result = new ArrayList<>();
        try { result = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {}); {
        }
        }
        catch (IOException except){
            except.printStackTrace();
        }
        return result;
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop){
        this.laptopi = vratiPodatkeIzDatoteke(); // prvo vrati postojecu listu
        laptopi.add(laptop);
        // zapisi u datoteku
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Laptop> result = new ArrayList<>();
        try { mapper.writeValue(file,result.getClass());
            this.laptopi=result;
        }
        catch (IOException except){
            except.printStackTrace();
        }
    }
}
