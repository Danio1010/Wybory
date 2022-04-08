package cover;

public class MinimalizujacyJednocechowyPartyjny extends MinimalizujacyJednocechowy {
    private String partia;

    public MinimalizujacyJednocechowyPartyjny(String imie, String nazwisko, int numerCechy, String partia) {
        super(imie, nazwisko, numerCechy);
        this.partia = partia;
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return this.dajKandydatówPartii(okregWyborczy,this.partia);
    }

}
