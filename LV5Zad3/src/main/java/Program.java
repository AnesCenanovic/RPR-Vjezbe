import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Primjer s starom KolekcijaImena
        ArrayList<String> listaImena = new ArrayList<>();
        listaImena.add("John Doe");
        listaImena.add("Jane Smith");
        listaImena.add("Michael Johnson");

        KolekcijaImena staraKolekcija = new KolekcijaImena(listaImena);

        Pobjednik pobjednikStara = new Pobjednik(staraKolekcija);
        System.out.println("Staro: " + pobjednikStara.getIme() + " " + pobjednikStara.getPrezime());

        // Primjer s novom KolekcijaImenaIPrezimena
        ArrayList<String> listaImenaNovo = new ArrayList<>();
        ArrayList<String> listaPrezimenaNovo = new ArrayList<>();
        listaImenaNovo.add("Ana");
        listaPrezimenaNovo.add("Ivanova");
        listaImenaNovo.add("Marko");
        listaPrezimenaNovo.add("Marinkovic");

        KolekcijaImenaIPrezimena novaKolekcija = new KolekcijaImenaIPrezimena(listaImenaNovo, listaPrezimenaNovo);


        Pobjednik pobjednikNova = new Pobjednik(novaKolekcija);
        System.out.println("Novo: " + pobjednikNova.getIme() + " " + pobjednikNova.getPrezime());


    }
}
