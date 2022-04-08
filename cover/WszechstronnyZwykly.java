package cover;

public class WszechstronnyZwykly extends Wszechstronny {
    public WszechstronnyZwykly(String imie, String nazwisko, int[] tablicaWagCech) {
        super(imie, nazwisko, tablicaWagCech);
    }

    @Override
    protected Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy) {
        return okregWyborczy.dajWszystkichKandydatow();
    }
}
