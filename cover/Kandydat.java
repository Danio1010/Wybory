package cover;

public class Kandydat {
    private String imie;
    private String nazwisko;
    private String nazwaPartii;
    private int[] cechy;
    private int numerNaLiscie;
    private int liczbaGlosow;

    public Kandydat(String imie, String nazwisko,String numerOkregu, String partia, int poz, int[] tablicaCech){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwaPartii = partia;
        this.numerNaLiscie = poz;
        this.cechy = new int[tablicaCech.length];
        System.arraycopy(tablicaCech,0,this.cechy,0,tablicaCech.length);
    }

    public String dajPartie() {
        return this.nazwaPartii;
    }

    public int[] dajCechy() {
        return this.cechy;
    }

    public void zaglosuj() {
        this.liczbaGlosow++;
    }

    public int dajIloscGlosow() {
        return this.liczbaGlosow;
    }

    public String dajImie() {
        return this.imie;
    }

    public String  dajNaziwsko() {
        return this.nazwisko;
    }

    public int dajNumer() {
        return this.numerNaLiscie;
    }

    public int dajGlosy() {
        return this.liczbaGlosow;
    }

    public int dajCeche(int numerCechy) {
        return this.cechy[numerCechy - 1];
    }
}
