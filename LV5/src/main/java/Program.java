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

        KolekcijaPoruka kolekcijaPoruka = new KolekcijaPoruka(listaInformacija);
        List<Informacije> porukeIzKolekcije = kolekcijaPoruka.getPoruke();

        for (Informacije poruka : porukeIzKolekcije) {
            System.out.println(poruka.predstavi());
        }
    }
}
