package com.example.lv4;

import java.io.*;
import java.util.*;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class LaptopDaoXMLFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file){
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
        XmlMapper mapper = new XmlMapper();
        ArrayList<Laptop> result = new ArrayList<>();
        try { result = mapper.readValue(file,result.getClass());
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
        XmlMapper mapper = new XmlMapper();
        ArrayList<Laptop> result = new ArrayList<>();
        try { mapper.writeValue(file,result.getClass());
            this.laptopi=result;
        }
        catch (IOException except){
            except.printStackTrace();
        }
    }
}
