package cover;

import java.util.concurrent.ThreadLocalRandom;

public class ŻelaznyElektoratPartyjny extends Wyborca {

    private String partia;

    public ŻelaznyElektoratPartyjny(String imie, String nazwisko,String partia) {
        super(imie, nazwisko);
        this.partia = partia;
    }

    @Override
    public void oddajGlos(OkregWyborczy okregWyborczy) {
        Kandydat[] kandydaci = this.dajKandydatówPartii(okregWyborczy,this.partia);
        int index = ThreadLocalRandom.current().nextInt(0, kandydaci.length);

        this.zaglosuj(kandydaci[index]);
    }

    @Override
    public void indoktrynuj(Dzialanie dzialanie) {

    }

    @Override
    public int dajSumeCech(Kandydat kandydat) {
        return 0;
    }

    @Override
    public int[] dajWagi() {
        return null;
    }
}
