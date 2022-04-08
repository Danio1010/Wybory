package cover;

public class Skromna extends Partia {

    public Skromna(String nazwa, int budzet, int liczbaDzialan) {
        super(nazwa, budzet, liczbaDzialan);
    }

    @Override
    protected boolean warunekWyboru(OkregWyborczy najlepszyOkreg, Dzialanie najlepszeDzialanie, OkregWyborczy okregWyborczy, Dzialanie dzialanie, int budzet) {
        return (okregWyborczy.dajKosztDzialania(dzialanie) < najlepszyOkreg.dajKosztDzialania(najlepszeDzialanie)
                && okregWyborczy.dajKosztDzialania(dzialanie) < budzet);
    }

}
