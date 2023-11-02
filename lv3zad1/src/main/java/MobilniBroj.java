public class MobilniBroj extends TelefonskiBroj {


    int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = String.format("03%d" , mobilnaMreza) + "/" + broj;
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
