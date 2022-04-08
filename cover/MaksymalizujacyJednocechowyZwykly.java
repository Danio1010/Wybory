package cover;

public class MaksymalizujacyJednocechowyZwykly extends MaksymalizujacyJednocechowy {
    public MaksymalizujacyJednocechowyZwykly(String imie, String nazwisko, int numerCechy) {
        super(imie, nazwisko, numerCechy);
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return okregWyborczy.dajWszystkichKandydatow();
    }
}
