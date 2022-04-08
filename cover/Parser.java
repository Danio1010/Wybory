package cover;

import java.io.File;
import java.util.Scanner;

public class Parser {
    public static Pair<OkregWyborczy[],Partia[]> wczytajDaneOKampani(File plik) throws Exception {

        Scanner scanner = new Scanner(plik);

        int liczbaOkregow = 5;
        int liczbaPartii;
        int liczbaDzialan;
        int liczbaCech;

        int liczbaPar;

        OkregWyborczy[] okregi = new OkregWyborczy[0];
        Partia[] partie = new Partia[0];
        
            String aktualnaLinia = scanner.nextLine();
            String[] param1 = aktualnaLinia.split(" ");


            liczbaOkregow = Integer.parseInt(param1[0]);
            liczbaPartii = Integer.parseInt(param1[1]);
            liczbaDzialan = Integer.parseInt(param1[2]);
            liczbaCech = Integer.parseInt(param1[3]);

            aktualnaLinia = scanner.nextLine();
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < aktualnaLinia.length(); i++) {
                if(aktualnaLinia.charAt(i) == '(' || aktualnaLinia.charAt(i) == ',' || aktualnaLinia.charAt(i) == ')') {
                    temp.append(" ");
                } else {
                    temp.append(aktualnaLinia.charAt(i));
                }
            }

            param1 = temp.toString().split("\\s+");

            liczbaPar = Integer.parseInt(param1[0]);

            String[] jakPolaczycOkregi = param1;

            aktualnaLinia = scanner.nextLine();
            param1 = aktualnaLinia.split(" ");

            String[] nazwyPartii = new String[liczbaPartii];
            int[] budzetyPartii = new int[liczbaPartii];
            String[] strategieParti = new String[liczbaPartii];

            for (int i = 0; i < liczbaPartii; i++) {
                nazwyPartii[i] = param1[i];
            }

            aktualnaLinia = scanner.nextLine();
            param1 = aktualnaLinia.split(" ");

            for (int i = 0; i < liczbaPartii; i++) {
                budzetyPartii[i] = Integer.parseInt(param1[i]);
            }

            aktualnaLinia = scanner.nextLine();
            param1 = aktualnaLinia.split(" ");

            for (int i = 0; i < liczbaPartii; i++) {
                strategieParti[i] = param1[i];
            }

            partie = stworzPartie(nazwyPartii,budzetyPartii,strategieParti,liczbaPartii,liczbaDzialan);

            aktualnaLinia = scanner.nextLine();
            param1 = aktualnaLinia.split(" ");

            int iloscKandydatow = 0;
            int iloscWyborcow = 0;

            int[] ileWyborcowWOkregu = new int[liczbaOkregow];

            for (int i = 0; i < liczbaOkregow; i++) {
                ileWyborcowWOkregu[i] = Integer.parseInt(param1[i]);
                iloscKandydatow += Integer.parseInt(param1[i]) / 10 * liczbaPartii;
                iloscWyborcow += Integer.parseInt(param1[i]);
            }

            Kandydat[][] wszyscyKandydaci = new Kandydat[liczbaOkregow][];
            for (int i = 0; i < liczbaOkregow; i++) {

                Kandydat[] kandydaci = new Kandydat[ileWyborcowWOkregu[i] / 10 * liczbaPartii];

                for (int k = 0; k < ileWyborcowWOkregu[i] / 10 * liczbaPartii; k++) {
                    aktualnaLinia = scanner.nextLine();
                    param1 = aktualnaLinia.split(" ");

                    int[] tablicaCech = new int[liczbaCech];
                    for (int z = 0; z < tablicaCech.length; z++) {
                        tablicaCech[z] = Integer.parseInt(param1[z + 5]);
                    }

                    kandydaci[k] = new Kandydat(param1[0],param1[1],param1[2],param1[3],Integer.parseInt(param1[4]),tablicaCech);
                }
                wszyscyKandydaci[i] = kandydaci;
            }



            int aktualnyNumerOkregu = 1;
            int iloscDoDodania = ileWyborcowWOkregu[0];
            int indexWyborcy = 0;

            Wyborca[][] wszyscyWyborcy = new Wyborca[liczbaOkregow][];

            for(int i = 0; i < liczbaOkregow; i++) {

                Wyborca[] wyborcy = new Wyborca[ileWyborcowWOkregu[i]];
                for (int j = 0; j < ileWyborcowWOkregu[i]; j++) {
                    aktualnaLinia = scanner.nextLine();
                    param1 = aktualnaLinia.split(" ");

                    Wyborca nowyWyborca;
                    int typStrategii = Integer.parseInt(param1[3]);

                    switch (typStrategii) {
                        case 1:
                            nowyWyborca = new ŻelaznyElektoratPartyjny(param1[0], param1[1], param1[4]);
                            break;
                        case 2:
                            nowyWyborca = new ŻelaznyElektoratKandydata(param1[0], param1[1], param1[4], Integer.parseInt(param1[5]));
                            break;
                        case 3:
                            nowyWyborca = new MinimalizujacyJednocechowyZwykly(param1[0], param1[1], Integer.parseInt(param1[4]));
                            break;
                        case 4:
                            nowyWyborca = new MaksymalizujacyJednocechowyZwykly(param1[0], param1[1], Integer.parseInt(param1[4]));
                            break;
                        case 5:
                            int[] tablicaCech = new int[liczbaCech];
                            for (int z = 0; z < tablicaCech.length; z++) {
                                tablicaCech[z] = Integer.parseInt(param1[z + 4]);
                            }
                            nowyWyborca = new WszechstronnyZwykly(param1[0], param1[1], tablicaCech);
                            break;
                        case 6:
                            nowyWyborca = new MinimalizujacyJednocechowyPartyjny(param1[0], param1[1], Integer.parseInt(param1[4]), param1[5]);
                            break;
                        case 7:
                            nowyWyborca = new MaksymalizujacyJednocechowyPartyjny(param1[0], param1[1], Integer.parseInt(param1[4]), param1[5]);
                            break;
                        case 8:
                            int[] tablicaCech2 = new int[liczbaCech];
                            for (int z = 0; z < tablicaCech2.length; z++) {
                                tablicaCech2[z] = Integer.parseInt(param1[z + 4]);
                            }
                            nowyWyborca = new WszechstronnyPartyjny(param1[0], param1[1], tablicaCech2, param1[liczbaCech + 4]);
                            break;
                        default:
                            throw new Exception("Brak takiego wyborcy");
                    }

                    wyborcy[j] = nowyWyborca;

                }
                    wszyscyWyborcy[i] = wyborcy;

            }

                Dzialanie[] wszystkieDzialania = new Dzialanie[liczbaDzialan];

                for(int i = 0; i < liczbaDzialan; i++) {
                    aktualnaLinia = scanner.nextLine();
                    aktualnaLinia = aktualnaLinia.trim();
                    param1 = aktualnaLinia.split("\\s+");

                    int[] dzialanie = new int[liczbaCech];
                    for(int j = 0; j < liczbaCech; j++) {
                        dzialanie[j] = Integer.parseInt(param1[j]);
                    }
                    wszystkieDzialania[i] = new Dzialanie(dzialanie);
                }

                for(Partia partia : partie) {
                    partia.nadajDzialania(wszystkieDzialania);
                }

                okregi = StworzOkregi(wszyscyKandydaci,wszyscyWyborcy,liczbaOkregow);

                for (int i = 1; i <= liczbaPar * 2; i += 2) {
                    int index1 = Integer.parseInt(jakPolaczycOkregi[i]);
                    int index2 = Integer.parseInt(jakPolaczycOkregi[i + 1]);
                    okregi[index1 - 1].polaczZ(okregi[index2 - 1],index2);
                    okregi[index2 - 1].polaczZ(okregi[index1 - 1],index1);
                }
            return new Pair<>(okregi,partie);
        }

    private static Partia[] stworzPartie(String[] nazwyPartii, int[] budzetyPartii, String[] strategieParti, int liczbaPartii, int liczbaDzialan) throws Exception {
        Partia[] partie = new Partia[liczbaPartii];
        for(int i = 0; i < liczbaPartii; i++) {
            Partia nowaPartia;
            switch (strategieParti[i]) {
                case "R":
                    nowaPartia = new ZRozmachem(nazwyPartii[i],budzetyPartii[i],liczbaDzialan);
                    break;
                case "S":
                    nowaPartia = new Skromna(nazwyPartii[i],budzetyPartii[i],liczbaDzialan);
                    break;
                case "W":
                    nowaPartia = new Wlasna(nazwyPartii[i],budzetyPartii[i],liczbaDzialan);
                    break;
                case "Z":
                    nowaPartia = new Zachlanna(nazwyPartii[i],budzetyPartii[i],liczbaDzialan);
                    break;
                default:
                    throw new Exception("Brak takiej partii");
            }
            partie[i] = nowaPartia;
    }
        return partie;

}

    private static OkregWyborczy[] StworzOkregi(Kandydat[][] wszyscyKandydaci, Wyborca[][] wszyscyWyborcy, int liczbaOkregow) {
        OkregWyborczy[] okregi = new OkregWyborczy[liczbaOkregow];

        for(int i = 0; i < liczbaOkregow; i++) {
            okregi[i] = new OkregWyborczy(wszyscyWyborcy[i],wszyscyKandydaci[i],i + 1);
        }

        return okregi;
    }
}
