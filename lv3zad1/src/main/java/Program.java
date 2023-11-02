
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg) throws Izuzetak {
        FiksniBroj.Grad grad= FiksniBroj.Grad.valueOf("MOSTAR");
        String broj= "123-456";
        TelefonskiBroj telefon = new FiksniBroj(grad,broj);
        String rjesenje = telefon.ispisi();
        System.out.println("\n" + rjesenje);
        int MobilnaMreza=62;
        TelefonskiBroj mobitel = new MobilniBroj(MobilnaMreza,broj);
        System.out.println("\n" + mobitel.ispisi());
        String drzava="+387";
        TelefonskiBroj medunarodnibroj=new MedunarodniBroj(drzava,broj);
        System.out.println("\n" + medunarodnibroj.ispisi());

        Imenik imenik = new Imenik();
        String ime="Playboi Carti";
        telefon=new FiksniBroj(grad,"666-666");
        imenik.dodaj(ime,telefon);
        ime="Kendrick Lamar";
        telefon=new FiksniBroj(grad,"100-100");
        imenik.dodaj(ime,telefon);
        ime="Samir Ribic";
        telefon=new FiksniBroj(grad,"999-999");
        imenik.dodaj(ime,telefon);
        ime="21 SAVAGE";
        telefon=new FiksniBroj(grad,"696-420");
        imenik.dodaj(ime,telefon);
        System.out.println("\n" + imenik.dajIme(telefon));
        System.out.println("\n" + imenik.dajBroj("21 SAVAGE"));
        System.out.println("\n" + imenik.naSlovo('P'));
        System.out.println("\n" + imenik.naSlovo('K'));
        System.out.println("\n" + imenik.izGrada(grad));
        System.out.println("\n" + imenik.izGradaBrojevi(grad));

        try{
            ime="Ye";
            if(ime.equals("Ye"))
                throw new Izuzetak("Redacted.");
        }catch(Izuzetak poruka)
        {
            System.out.println("Izuzetak: " + poruka);
        }
    }
}
