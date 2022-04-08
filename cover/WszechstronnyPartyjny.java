package cover;

public class WszechstronnyPartyjny extends Wszechstronny {
    private String partia;
    public WszechstronnyPartyjny(String imie, String nazwisko, int[] tablicaWagCech,String partia) {
        super(imie, nazwisko, tablicaWagCech);
        this.partia = partia;
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return this.dajKandydatówPartii(okregWyborczy,this.partia);
    }
}
