package cover;

public class MetodaDHondta extends MetodaZliczaniaGlosow {
    @Override
    public int[] dajLiczbeMandatow(int[] glosyNaPartie, int liczbaMandatow) {
        int[] mandaty = new int[glosyNaPartie.length];

        int[] ilorazyMetody = new int[glosyNaPartie.length];
        System.arraycopy(glosyNaPartie, 0, ilorazyMetody, 0, glosyNaPartie.length);

        int maxPartia = 0;
        for(int i = 0; i < liczbaMandatow; i++) {
            int max = -1;
            for(int j = 0; j < glosyNaPartie.length; j++) {
                if (ilorazyMetody[j] > max) {
                    maxPartia = j;
                    max = ilorazyMetody[j];
                }
            }

            mandaty[maxPartia]++;
            ilorazyMetody[maxPartia] = glosyNaPartie[maxPartia] / (mandaty[maxPartia] + 1);
        }

        return mandaty;
    }

    @Override
    public void wypiszNazweMetody() {
        System.out.printf("%s\n","Metoda D'Hondta");
    }
}
