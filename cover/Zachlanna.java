package cover;

public class Zachlanna extends Partia {
    public Zachlanna(String nazwa, int budzet, int liczbaDzialan) {
        super(nazwa, budzet, liczbaDzialan);
    }


    @Override
    protected boolean warunekWyboru(OkregWyborczy najlepszyOkreg, Dzialanie najlepszeDzialanie, OkregWyborczy okregWyborczy, Dzialanie dzialanie, int budzet) {
        int suma1 = okregWyborczy.dajSumeWazonaKandydatow();
        int suma2 = okregWyborczy.dajSumeWazonaKandydatowPoDzialaniu(dzialanie);
        int sumaNajlesza1 = najlepszyOkreg.dajSumeWazonaKandydatow();
        int sumaNajlepsza = najlepszyOkreg.dajSumeWazonaKandydatowPoDzialaniu(najlepszeDzialanie);

        if(sumaNajlepsza - sumaNajlesza1 < suma2 - suma1 && okregWyborczy.dajKosztDzialania(dzialanie) < budzet) {
            return true;
        } else {
            return false;
        }
    }
}
