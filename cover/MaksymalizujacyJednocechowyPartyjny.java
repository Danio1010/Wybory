package cover;

public class MaksymalizujacyJednocechowyPartyjny extends MaksymalizujacyJednocechowy {
    private String partia;
    public MaksymalizujacyJednocechowyPartyjny(String imie, String nazwisko, int numerCechy, String partia) {
        super(imie, nazwisko, numerCechy);
        this.partia = partia;
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return this.dajKandydatówPartii(okregWyborczy,this.partia);

    }
}
