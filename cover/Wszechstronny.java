package cover;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Wszechstronny extends Wyborca {
    private int[] tablicaWagCech;

    public Wszechstronny(String imie, String nazwisko, int[] tablicaWagCech) {
        super(imie, nazwisko);
        this.tablicaWagCech = tablicaWagCech;
    }

    @Override
    public void oddajGlos(OkregWyborczy okregWyborczy) {
        Kandydat[] kandydaci = this.wybierzKandydatow(okregWyborczy);
        Kandydat najlepszyKandydat = kandydaci[0];
        int sumaWazona = this.policzSume(kandydaci[0]);

        for(Kandydat kandydat : kandydaci) {
            if(sumaWazona < policzSume(kandydat)) {
                najlepszyKandydat = kandydat;
            }
            else if(sumaWazona == policzSume(kandydat) &&
                    ThreadLocalRandom.current().nextInt(0, 2) == 1) {
                najlepszyKandydat = kandydat;
            }

        }

        this.zaglosuj(najlepszyKandydat);
    }

    protected int policzSume(Kandydat kandydat) {
        int[] tablicaCech = kandydat.dajCechy();
        int suma = 0;
        for(int i = 0; i < tablicaCech.length; i++) {
            suma += tablicaCech[i] * this.tablicaWagCech[i];
        }
        return suma;
    }

    protected abstract Kandydat[] wybierzKandydatow(OkregWyborczy okregWyborczy);

    public void indoktrynuj(Dzialanie dzialanie) {
        for(int i = 0; i < tablicaWagCech.length; i++) {
            tablicaWagCech[i] = Math.max(Math.min(tablicaWagCech[i] + dzialanie.dajDzialanie()[i],100),-100);
        }
    }

    public int dajSumeCech(Kandydat kandydat) {
        return this.policzSume(kandydat);
    }

    public int[] dajWagi() {
        return this.tablicaWagCech;
    }
}
