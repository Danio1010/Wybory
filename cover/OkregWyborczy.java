package cover;

public class OkregWyborczy {
    private Wyborca[] wyborcy;
    private Kandydat[] kandydaci;
    private OkregWyborczy polaczonyOkreg;
    private int numerOkregu;
    private int numerPolaczonegoOkregu;

    public OkregWyborczy(Wyborca[] wyborcy, Kandydat[] kandydaci,int numerOkregu) {
        this.wyborcy = wyborcy;
        this.kandydaci = kandydaci;
        this.numerOkregu = numerOkregu;
    }

    public void polaczZ(OkregWyborczy okregWyborczy,int num) {
        this.numerPolaczonegoOkregu = num;
        this.polaczonyOkreg = okregWyborczy;
    }

    public Kandydat[] dajKandydatowOkregowi() {
        return this.kandydaci;
    }

    public Kandydat[] dajWszystkichKandydatow() {
        if(polaczonyOkreg == null) {
            return this.kandydaci;
        } else {
            int dlugosc1 = this.kandydaci.length;
            int dlugosc2 = this.polaczonyOkreg.dajKandydatowOkregowi().length;

            //moze popraw to zeby doklejalo do PartiX ludzie z Partix i tak dalej bo narazie skleja na pale
            Kandydat[] polaczeniKandydaci = new Kandydat[dlugosc1 + dlugosc2];
            // zawsze bedzie najpierw bral kandydatow z swojego okregu (wyborca)
            System.arraycopy(this.kandydaci, 0, polaczeniKandydaci, 0, dlugosc1);
            System.arraycopy(this.polaczonyOkreg.dajKandydatowOkregowi(),0,polaczeniKandydaci,dlugosc1,dlugosc2);

            return polaczeniKandydaci;
        }
    }

    //rozszerz komendy do startegii partii dla polaczonych okregow
    public int dajKosztDzialania(Dzialanie dzialanie) {
        return dzialanie.dajWartoscBezwzgledna() * this.dajWszystkichWyborcow().length;
    }

    public Wyborca[] dajWyborcowZOkregu() {
        return this.wyborcy;
    }

    public Wyborca[] dajWszystkichWyborcow() {
        if(polaczonyOkreg != null) {
            int dlugosc1 = this.wyborcy.length;
            int dlugosc2 = this.polaczonyOkreg.dajWyborcowZOkregu().length;

            //moze popraw to zeby doklejalo do PartiX ludzie z Partix i tak dalej bo narazie skleja na pale
            Wyborca[] polaczeniWyborcy = new Wyborca[dlugosc1 + dlugosc2];
            // zawsze bedzie najpierw bral kandydatow z swojego okregu (wyborca)
            System.arraycopy(this.wyborcy, 0, polaczeniWyborcy, 0, dlugosc1);
            System.arraycopy(this.polaczonyOkreg.dajWyborcowZOkregu(),0,polaczeniWyborcy,dlugosc1,dlugosc2);

            return polaczeniWyborcy;
        } else {
            return this.wyborcy;
        }
    }

    public int dajSumeWazonaKandydatow() {
        int suma = 0;
        for(Kandydat kandydat : this.dajWszystkichKandydatow()) {
            for(Wyborca wyborca : this.dajWszystkichWyborcow()) {
                suma += wyborca.dajSumeCech(kandydat);
            }
        }
        return suma;
    }

    public int dajSumeWazonaKandydatowPoDzialaniu(Dzialanie dzialanie) {
        int suma = 0;
        for(Kandydat kandydat : this.dajWszystkichKandydatow()) {
            int[] cechy = kandydat.dajCechy();
            int[] zmiany = dzialanie.dajDzialanie();
            for(Wyborca wyborca : this.dajWszystkichWyborcow()) {
                int[] wagi = wyborca.dajWagi();
                if(wagi != null) {
                    for (int i = 0; i < cechy.length; i++) {
                        suma += cechy[i] * (Math.max(Math.min(wagi[i] + zmiany[i], 100), -100));
                    }
                }
            }
        }
        return suma;
    }

    public int policzGlosyNaPartie(Partia partia) {
        int suma = 0;
        for(Kandydat kandydat : this.kandydaci) {
            if(kandydat.dajPartie().compareTo(partia.dajNazwe()) == 0) {
                suma += kandydat.dajIloscGlosow();
            }
        }
        return suma;
    }

    public int dajLiczbeMandatow() {
        return wyborcy.length / 10;
    }

    public OkregWyborczy dajPolaczonyOkreg() {
        return this.polaczonyOkreg;
    }

    public int dajNumerPolaczonego() {
        return this.numerPolaczonegoOkregu;
    }
}
