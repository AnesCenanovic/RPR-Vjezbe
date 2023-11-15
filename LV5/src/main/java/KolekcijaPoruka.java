import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {

    private ArrayList<Informacije> poruke;

    public KolekcijaPoruka(ArrayList<Informacije> poruke){
        this.poruke = poruke;
    }

    public ArrayList<Informacije> getPoruke() {
        return poruke;
    }

}
