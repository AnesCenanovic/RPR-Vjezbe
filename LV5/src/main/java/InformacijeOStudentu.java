public class InformacijeOStudentu extends LicneInformacije implements Informacije ,MozeOcijeniti{

    private String godinaStudija;
    private String brojIndexa;

    public InformacijeOStudentu(String godinaStudija, String brojIndexa,String ime, String prezime){
            this.brojIndexa=brojIndexa;
            this.godinaStudija=godinaStudija;
            this.setIme(ime);
            this.setPrezime(prezime);
    }

    @Override
    public String predstavi(){
        return getIme() + " " + getPrezime() + " " + getGodinaStudija() + " " + getBrojIndexa();
    }
    @Override
    public Ocjena ocijeni(int x){
        LicneInformacije osoba = new LicneInformacije(this.getIme(),this.getPrezime());
        return new Ocjena(osoba,x);
    }

    public String getGodinaStudija(){
        return this.godinaStudija;
    }
    public String getBrojIndexa(){
        return this.brojIndexa;
    }

    public void setGodinaStudija(String godinaStudija){
        this.godinaStudija=godinaStudija;
    }
    public void setBrojIndexa(String brojIndexa){
        this.brojIndexa=brojIndexa;
    }

}
