import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args){

        LicneInformacije licneInformacije = new LicneInformacije("John", "Doe");
        InformacijeOStudentu informacijeOStudentu = new InformacijeOStudentu("Jane", "Doe", "3", "123456");
        InformacijaONastavniku informacijeONastavniku = new InformacijaONastavniku("Prof", "Smith", "Ph.D.");
        Predmet predmet = new Predmet("Programiranje", "Učenje programiranja");

        ArrayList<Informacije> listaInformacija = new ArrayList<>();
        listaInformacija.add(licneInformacije);
        listaInformacija.add(informacijeOStudentu);
        listaInformacija.add(informacijeONastavniku);
        listaInformacija.add(predmet);

        Ocjena ocjena1 = new Ocjena(informacijeOStudentu,6);
        Ocjena ocjena2 = new Ocjena(informacijeONastavniku,6);
        Ocjena ocjena3 = new Ocjena(informacijeOStudentu,8);

        ArrayList<Ocjena> ocjene = new ArrayList<>();
        ocjene.add(ocjena1);
        ocjene.add(ocjena2);
        ocjene.add(ocjena3);

        for(Ocjena a : ocjene){
            if(a instanceof MozeOcijeniti){
                informacijeONastavniku.setOcjene(a);
                predmet.setOcjene(a);
            }
            else{
                predmet.setOcjene(a);
            }
        }



        KolekcijaPoruka kolekcijaPoruka = new KolekcijaPoruka(listaInformacija);
        List<Informacije> porukeIzKolekcije = kolekcijaPoruka.getPoruke();

        for (Informacije poruka : porukeIzKolekcije) {
            System.out.println(poruka.predstavi());
        }

    }
}
