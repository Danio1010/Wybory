package cover;

public class MinimalizujacyJednocechowyZwykly extends MinimalizujacyJednocechowy {

    public MinimalizujacyJednocechowyZwykly(String imie, String nazwisko, int numerCechy) {
        super(imie,nazwisko,numerCechy);
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return okregWyborczy.dajWszystkichKandydatow();
    }
}
