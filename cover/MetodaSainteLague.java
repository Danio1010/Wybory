package cover;

public class MetodaSainteLague extends MetodaZliczaniaGlosow {
    @Override
    public int[] dajLiczbeMandatow(int[] glosyNaPartie, int liczbaMandatow) {
        int[] mandaty = new int[glosyNaPartie.length];

        for(int i = 0; i < liczbaMandatow; i++) {
            int maxPartia = 0;
            for(int j = 0; j < glosyNaPartie.length; j++) {
                if(glosyNaPartie[j]/(2 * mandaty[j] + 1) > glosyNaPartie[maxPartia] / (2 * mandaty[maxPartia] + 1)) {
                    maxPartia = j;
                }
            }
            mandaty[maxPartia]++;
        }
        return mandaty;
    }

    @Override
    public void wypiszNazweMetody() {
        System.out.printf("%s\n","Metoda Sainte-Lague");
    }
}
