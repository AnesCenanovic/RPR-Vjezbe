public class MedunarodniBroj extends TelefonskiBroj{

    String drzava;
    private String broj;

    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = drzava + "/" + broj;
    }

    @Override
    public String ispisi() {
        return broj;
    }

    @Override
    public int hashCode(){
        return broj.hashCode();
    }
}
