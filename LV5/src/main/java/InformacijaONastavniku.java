public class InformacijaONastavniku extends LicneInformacije implements Informacije{

    private String titula;

    public InformacijaONastavniku(String ime, String prezime, String titula){
        this.setIme(ime);
        this.setPrezime(prezime);
        this.titula=titula;
    }

    @Override
    public String predstavi(){
        return getIme() + " " + getPrezime() + " , " + getTitula();
    }

    public String getTitula(){
        return this.titula;
    }

    public void setGodinaStudija(String titula){
        this.titula=titula;
    }

}
