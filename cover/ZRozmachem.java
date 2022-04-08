package cover;

public class ZRozmachem extends Partia {


    public ZRozmachem(String nazwa, int budzet, int liczbaDzialan) {
        super(nazwa,budzet,liczbaDzialan);
    }

    @Override
    protected boolean warunekWyboru(OkregWyborczy najlepszyOkreg, Dzialanie najlepszeDzialanie, OkregWyborczy okregWyborczy, Dzialanie dzialanie, int budzet) {
        return (okregWyborczy.dajKosztDzialania(dzialanie) > najlepszyOkreg.dajKosztDzialania(najlepszeDzialanie)
                && okregWyborczy.dajKosztDzialania(dzialanie) < budzet);
    }

}
