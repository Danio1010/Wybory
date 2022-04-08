package cover;

public abstract class Partia {
    private Dzialanie[] dzialania;
    private String nazwaPartii;
    private int budzet;
    private boolean koniecKampanii;

    public Partia(String nazwa,int budzet,int liczbaDzialan) {
        this.nazwaPartii = nazwa;
        this.budzet = budzet;
        this.dzialania = new Dzialanie[liczbaDzialan];
        this.koniecKampanii = false;
    }

    public void wykonajDzialaniePropagandowe(OkregWyborczy[] okregiWyborcze) {
        Pair<Dzialanie,OkregWyborczy> para = this.wybierzDzialanie(okregiWyborcze,dzialania,budzet);
        Dzialanie najlepszeDzialanie = para.getKey();
        OkregWyborczy okreg = para.getValue();
        if(najlepszeDzialanie != null && okreg != null) {
            this.budzet -= okreg.dajKosztDzialania(najlepszeDzialanie);
            this.indoktrynujObywateli(najlepszeDzialanie, okreg);
        } else {
            this.koniecKampanii = true;
        }
    }

    private void indoktrynujObywateli(Dzialanie najlepszeDzialanie, OkregWyborczy okreg) {
        Wyborca[] obywatele = okreg.dajWszystkichWyborcow();

        for(Wyborca obywatel : obywatele) {
            obywatel.indoktrynuj(najlepszeDzialanie);
        }
    }


    public void nadajDzialania(Dzialanie[] wszystkieDzialania) {
        this.dzialania = wszystkieDzialania;
    }

    public Pair<Dzialanie,OkregWyborczy> wybierzDzialanie(OkregWyborczy[] okregiWyborcze, Dzialanie[] dzialania, int budzet) {
        OkregWyborczy najlepszyOkreg = okregiWyborcze[0];
        Dzialanie najlepszeDzialanie = dzialania[0];
        for(OkregWyborczy okregWyborczy : okregiWyborcze) {
            for(Dzialanie dzialanie : dzialania) {
                if(this.warunekWyboru(najlepszyOkreg,najlepszeDzialanie,okregWyborczy,dzialanie,budzet)) {
                    najlepszyOkreg = okregWyborczy;
                    najlepszeDzialanie = dzialanie;
                }
            }
        }
        if(najlepszyOkreg.dajKosztDzialania(najlepszeDzialanie) > budzet) {
            return new Pair<>(null,null);
        } else {
            return new Pair<>(najlepszeDzialanie,najlepszyOkreg);
        }
    }

    protected abstract boolean warunekWyboru(OkregWyborczy najlepszyOkreg, Dzialanie najlepszeDzialanie, OkregWyborczy okregWyborczy, Dzialanie dzialanie, int budzet);

    public String dajNazwe() {
        return this.nazwaPartii;
    }

    public boolean czyKoniecKampanii() {
        return this.koniecKampanii;
    }
}
