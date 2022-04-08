package cover;

import java.util.concurrent.ThreadLocalRandom;

public class Wlasna extends Partia {
    public Wlasna(String nazwa, int budzet, int liczbaDzialan) {
        super(nazwa, budzet, liczbaDzialan);
    }

    @Override
    protected boolean warunekWyboru(OkregWyborczy najlepszyOkreg, Dzialanie najlepszeDzialanie, OkregWyborczy okregWyborczy, Dzialanie dzialanie, int budzet) {
        int i = ThreadLocalRandom.current().nextInt(0, 2);
        return okregWyborczy.dajKosztDzialania(dzialanie) < budzet && i == 1;

    }
}
