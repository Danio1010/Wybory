package cover;

public abstract class MinimalizujacyJednocechowy extends Wyborca {
    private int numerCechy;

    public MinimalizujacyJednocechowy(String imie, String nazwisko, int cecha) {
        super(imie, nazwisko);
        this.numerCechy = cecha;
    }

    @Override
    public void oddajGlos(OkregWyborczy okregWyborczy) {
        Kandydat[] kandydaci = this.wybierzKandydatow(okregWyborczy);
        Kandydat aktualnyNajlepszy = kandydaci[0];
        for(Kandydat kandydat : kandydaci) {
            if(kandydat.dajCeche(this.numerCechy) < aktualnyNajlepszy.dajCeche(numerCechy)) {
                aktualnyNajlepszy = kandydat;
            }
        }

        this.zaglosuj(aktualnyNajlepszy);
    }

    protected abstract Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy);

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
