package cover;

import java.util.ArrayList;
import java.util.List;

public abstract class Wyborca {
    private String imie;
    private String nazwisko;
    private Kandydat wybranyKandydat;

    public Wyborca(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public abstract void oddajGlos(OkregWyborczy okregWyborczy);

    public void zaglosuj(Kandydat kandydat) {
        this.wybranyKandydat = kandydat;
        kandydat.zaglosuj();
    }

    public Kandydat[] dajKandydatówPartii(OkregWyborczy okregWyborczy, String partia) {
        Kandydat[] kandydaci = okregWyborczy.dajWszystkichKandydatow();
        List<Kandydat> kandydaciPartii = new ArrayList<Kandydat>();

        for(Kandydat kandydat : kandydaci) {
            if(kandydat.dajPartie().compareTo(partia) == 0) {
                kandydaciPartii.add(kandydat);
            }
        }

        Kandydat[] ret = new Kandydat[kandydaciPartii.size()];
        for(int i = 0; i < kandydaciPartii.size(); i++) {
            ret[i] = kandydaciPartii.get(i);
        }
        return ret;
    }

    public abstract void indoktrynuj(Dzialanie dzialanie);

    public abstract int dajSumeCech(Kandydat kandydat);

    public abstract int[] dajWagi();

    public String dajImie() {
        return this.imie;
    }

    public String dajNaziwsko() {
        return this.nazwisko;
    }

    public String dajImieWybranego() {
        return this.wybranyKandydat.dajImie();
    }

    public String dajNazwiskoWybranego() {
        return this.wybranyKandydat.dajNaziwsko();
    }
}
