import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Imenik {

    private HashMap<String, TelefonskiBroj> imenik = new HashMap<>();

    public void dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime,broj);
    }

    public String dajBroj(String ime){
        TelefonskiBroj broj = imenik.get(ime);

        if(broj != null) {
            return broj.ispisi();
        }
        else {
            return "Osoba nije pronadjena!";
        }
    }

    public String dajIme(TelefonskiBroj broj){
        for(HashMap.Entry<String,TelefonskiBroj> entry : imenik.entrySet()){
            if(entry.getValue().equals(broj)){
                return entry.getKey();
            }
        }
        return "Broj nije pronadjen!";
    }

    public String naSlovo(char s){
        String result="";
        int counter=1;
        for(HashMap.Entry<String,TelefonskiBroj> entry : imenik.entrySet()){
            String ime = entry.getKey();
            if(ime.charAt(0) == s){
                String broj=entry.getValue().ispisi();
                result += counter + ". " + entry.getKey() + " - " + broj + "\n";
            }
        }
        return result;
    }

    public Set<String> izGrada(FiksniBroj.Grad grad){
        Set<String> osobe = new TreeSet<>();
        for(HashMap.Entry<String,TelefonskiBroj> entry : imenik.entrySet()){
            TelefonskiBroj broj = entry.getValue();
            if(broj instanceof FiksniBroj){
                FiksniBroj fixBroj = (FiksniBroj) broj;
                if(// neki nacin da se skonta grad samo iz broja){
                    osobe.add(entry.getKey());
                }
            }
        return osobe;
        }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad grad){
        Set<TelefonskiBroj> brojevi = new TreeSet<>();
        for(HashMap.Entry<String,TelefonskiBroj> entry : imenik.entrySet()){
            TelefonskiBroj broj = entry.getValue();
            if(broj instanceof FiksniBroj){
                FiksniBroj fixBroj = (FiksniBroj) broj;
                if(/ neki nacin da se skonta grad samo iz broja//){
                brojevi.add(broj);
            }
        }
        return brojevi;

    }
}

