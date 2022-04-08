package cover;

public class Symulacja {

    public static void symuluj(OkregWyborczy[] okregi,MetodaZliczaniaGlosow[] metody, Partia[] partie) {


        //dzialania partii
        while(!(czyJuzKoniecKampanii(partie))) {
            for(Partia partia : partie) {
                if(!(partia.czyKoniecKampanii())) {
                    partia.wykonajDzialaniePropagandowe(okregi);
                }
            }
        }


        // glosowanie
        for(OkregWyborczy okregWyborczy : okregi) {
            for(Wyborca wyborca : okregWyborczy.dajWyborcowZOkregu()) {
                wyborca.oddajGlos(okregWyborczy);
            }
        }

        int[][] liczbaGlosow = new int[okregi.length][partie.length];

        //liczenie
        for(int i = 0; i < okregi.length; i++) {
            for(int j = 0; j < partie.length; j++) {
                liczbaGlosow[i][j] = okregi[i].policzGlosyNaPartie(partie[j]);
            }
        }

        for(MetodaZliczaniaGlosow metoda : metody) {
            int[] calkowitaLiczbaMandatowPartii = new int[partie.length];
            boolean[] odwiedzoneOkregi = new boolean[okregi.length];
            metoda.wypiszNazweMetody();
            // wypisywanie informacji o okregach
            for (int i = 0; i < okregi.length; i++) {
                // implementacja liczaca mandaty w polączonych okregach łacznie;
                if (!odwiedzoneOkregi[i]) {
                    int[] liczbaGlosowPolaczona = new int[partie.length];
                    int liczbaMandatowPolaczona = okregi[i].dajLiczbeMandatow();
                    odwiedzoneOkregi[i] = true;
                    if(okregi[i].dajPolaczonyOkreg() != null) {
                        int numerPolaczonego = okregi[i].dajNumerPolaczonego();
                        odwiedzoneOkregi[numerPolaczonego - 1] = true;
                        for(int k = 0; k < partie.length; k++) {
                            liczbaGlosowPolaczona[k] = liczbaGlosow[numerPolaczonego - 1][k] + liczbaGlosow[i][k];
                        }
                        liczbaMandatowPolaczona += okregi[numerPolaczonego - 1].dajLiczbeMandatow();
                    } else {
                        liczbaGlosowPolaczona = liczbaGlosow[i];
                    }
                    System.out.printf("%d\n",i + 1);
                    for (Wyborca wyborca : okregi[i].dajWszystkichWyborcow()) {
                        System.out.printf("%s %s ", wyborca.dajImie(),wyborca.dajNaziwsko());
                        System.out.printf("%s %s\n",wyborca.dajImieWybranego(),wyborca.dajNazwiskoWybranego());
                    }
                    for (Kandydat kandydat : okregi[i].dajWszystkichKandydatow()) {
                        System.out.printf("%s %s ",kandydat.dajImie(),kandydat.dajNaziwsko());
                        System.out.printf("%s %d %d\n",kandydat.dajPartie(),kandydat.dajNumer(),kandydat.dajGlosy());
                    }
                    int[] liczbaMandatowPartii = new int[partie.length];

                    liczbaMandatowPartii = metoda.dajLiczbeMandatow(liczbaGlosowPolaczona, liczbaMandatowPolaczona);


                    for (int j = 0; j < partie.length; j++) {
                        System.out.printf("%s %d\n",partie[j].dajNazwe(),liczbaMandatowPartii[j]);
                        calkowitaLiczbaMandatowPartii[j] += liczbaMandatowPartii[j];
                    }
                }
            }

            for (int i = 0; i < partie.length; i++) {
                System.out.printf("%s %d\n", partie[i].dajNazwe(), calkowitaLiczbaMandatowPartii[i]);
            }
        }


    }

    private static boolean czyJuzKoniecKampanii(Partia[] partie) {
        for (Partia partia : partie) {
            if(!(partia.czyKoniecKampanii())) {
                return false;
            }
        }
        return true;
    }
}
