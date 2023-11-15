public class Predmet implements Informacije {

    private String naziv;
    private String opis;

    public Predmet(String naziv, String opis){
        this.opis=opis;
        this.naziv=naziv;
    }

    @Override
    public String predstavi(){
        return getNaziv() + " " + getOpis();
    }

    public String getNaziv(){
        return this.naziv;
    }
    public String getOpis(){
        return this.opis;
    }

    public void setNaziv(String naziv){
        this.naziv=naziv;
    }
    public void setOpis(String opis){
        this.opis=opis;
    }
}
