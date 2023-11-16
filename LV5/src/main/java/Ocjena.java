
public class Ocjena {

    private LicneInformacije osoba;
    private int ocjena;

    public Ocjena(LicneInformacije osoba, int ocjena){

        this.osoba=osoba;
        this.ocjena=ocjena;

    }

    public void setOcjena(int ocjena) throws IlegalanArgument {
        if(ocjena<0 || ocjena>10){
            throw new IlegalanArgument("Nedozvoljen argument");
        }
        this.ocjena=ocjena;
    }
}
