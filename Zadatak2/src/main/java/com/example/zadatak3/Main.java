package com.example.zadatak3;


import java.util.List;
public class Main{
    public class Osoba{

        private String ime;
        private String prezime;

        Osoba (String a,String b){

        }

        @Override
        public String toString(){
            return this.ime + this.prezime;
        }
    }
    public class Uposlenik extends Osoba{

        Uposlenik (String a,String b){
            super(a,b);
        }
    }
    public class Korisnik extends Osoba{

        Korisnik (String a,String b){
            super(a,b);
        }

        public void dodajRacun(Racun r){

        }
    }

    public class Racun{

        Racun (Long a,Osoba b){

        }

        public boolean provjeriOdobrenjePrekoracenja(Double r){
            return true;
        }
        public boolean izvrsiUplatu(Double r){
            return true;
        }
        public boolean izvrsiIsplatu(Double r){
            return true;
        }
        public void odobriPrekoracenje (Double r){

        }
    }

    public class Banka{

        private Long brojRacuna;

        Banka (){

        }

        public Korisnik kreirajNovogKorisnika(String a,String b){
            Korisnik bruh = new Korisnik(a,b);
            return bruh;
        }
        public Uposlenik kreirajNovogUposlenika(String a,String b){
            Uposlenik bruh = new Uposlenik(a,b);
            return bruh;
        }
        public Racun kreirajRacunZaKorisnika(Korisnik a){
            Racun bruh = new Racun(1000L,a);
            return bruh;
        }
    }


    public static void main(String[] args) {

        long brojRacuna;
        Osoba korisnikRacuna;
        boolean odobrenjePrekoracenja;
        double stanjeRacuna;
        Racun r;
        List<Korisnik> users;
        List<Uposlenik> employees;
    }
}