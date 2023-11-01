public class MobilniBroj extends TelefonskiBroj {


    int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = 0 + mobilnaMreza + "/" + broj;
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
