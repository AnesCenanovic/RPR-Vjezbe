public class LicneInformacije implements Informacije{

    private String ime;
    private String prezime;

    public LicneInformacije(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
    public LicneInformacije(){
    }

    @Override
    public String predstavi(){
        return getIme() + " " + getPrezime();
    }

    public String getIme(){
        return this.ime;
    }
    public String getPrezime(){
        return this.prezime;
    }

    public void setIme(String ime){
        this.ime=ime;
    }
    public void setPrezime(String prezime){
        this.prezime=prezime;
    }
}
