package cover;

public class MetodaHareNiemeyera extends MetodaZliczaniaGlosow {
    @Override
    public int[] dajLiczbeMandatow(int[] glosyNaPartie, int liczbaMandatow) {
        int[] mandaty = new int[glosyNaPartie.length];
        float[] wartosci = new float[glosyNaPartie.length];
        int suma = 0;
        for(Integer integer : glosyNaPartie) {
            suma += integer;
        }

        for(int i = 0; i < glosyNaPartie.length; i++) {
            wartosci[i] = (((float)glosyNaPartie[i] * (float)liczbaMandatow) / (float)suma);
        }


        for(int i = 0; i < glosyNaPartie.length; i++) {
            mandaty[i] += (int)wartosci[i];
            liczbaMandatow -= (int)wartosci[i];
        }

        boolean[] ktoJuzOtrzymal = new boolean[glosyNaPartie.length];
        while(liczbaMandatow > 0){
            int maxInd = 0;
            for(int i = 0; i < glosyNaPartie.length; i++) {
                if(ntyNumer(wartosci[i],2) > ntyNumer(wartosci[maxInd],2) && !ktoJuzOtrzymal[i]) {
                    maxInd = i;
                }
            }
            mandaty[maxInd] += 1;
            liczbaMandatow -= 1;
            ktoJuzOtrzymal[maxInd] = true;
        }

        return mandaty;
    }

    @Override
    public void wypiszNazweMetody() {
        System.out.printf("%s\n","Metoda Hare'a-Niemeyera");
    }

    public int ntyNumer(float f, int i) {
        f = (float) (f * (float)Math.pow(10,i));
        int temp = (int)f;
        temp = Math.floorMod(temp,10);

        return temp;

    }
}
