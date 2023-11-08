package com.example.lv4;


public abstract class Laptop implements LaptopDao{
    private String brend;
    private String model;
    private double cijena;
    private int ram;
    private int hdd;
    private int ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;

    public Laptop (){

    }

    public Laptop (String brend, String model, double cijena, int ram, int hdd, int ssd, String procesor, String grafickaKartica, double velicinaEkrana){
        this.brend=brend;
        this.cijena=cijena;
        this.grafickaKartica=grafickaKartica;
        this.model=model;
        this.hdd=hdd;
        this.ssd=ssd;
        this.ram=ram;
        this.procesor=procesor;
        this.velicinaEkrana=velicinaEkrana;
    }

    public String getBrend(){
        return this.brend;
    }
    public String getModel(){
        return this.model;
    }
    public double getCijena(){
        return this.cijena;
    }
    public int getRam(){
        return this.ram;
    }
    public int getHdd(){
        return this.hdd;
    }
    public int getSsd(){
        return this.ssd;
    }
    public String getProcesor(){
        return this.procesor;
    }
    public String getGrafickaKartica(){
        return this.grafickaKartica;
    }
    public double getVelicinaEkrana(){
        return this.velicinaEkrana;
    }


    public void setBrend(String brend){
        this.brend=brend;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setCijena(double cijena){
        this.cijena=cijena;
    }
    public void setRam(int ram){
        this.ram=ram;
    }
    public void setHdd(int hdd){
        this.hdd=hdd;
    }
    public void setSsd(int ssd){
        this.ssd=ssd;
    }
    public void setProcesor(String procesor){
        this.procesor=procesor;
    }
    public void setGrafickaKartica(String grafickaKartica){
        this.grafickaKartica=grafickaKartica;
    }
    public void setVelicinaEkrana(double velicinaEkrana){
        this.velicinaEkrana=velicinaEkrana;
    }




}