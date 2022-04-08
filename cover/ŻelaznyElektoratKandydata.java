package cover;

public class ŻelaznyElektoratKandydata extends Wyborca{
    private String partia;
    private int numerNaLiscie;

    public ŻelaznyElektoratKandydata(String imie, String nazwisko, String partia, int numerNaLiscie) {
        super(imie, nazwisko);
        this.numerNaLiscie = numerNaLiscie;
        this.partia = partia;
    }

    @Override
    public void oddajGlos(OkregWyborczy okregWyborczy) {
        Kandydat[] kandydaci = this.dajKandydatówPartii(okregWyborczy,partia);


        this.zaglosuj(kandydaci[numerNaLiscie - 1]);

    }

    @Override
    public void indoktrynuj(Dzialanie dzialanie) {

    }

    @Override
    public int dajSumeCech(Kandydat kandydat) {
        return 0;
    }

    @Override
    public int[] dajWagi() {
        return null;
    }
}
