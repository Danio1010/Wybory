package cover;


import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            File plik = new File(args[0]);
            Pair<OkregWyborczy[], Partia[]> daneDoSymulacji;
            daneDoSymulacji = Parser.wczytajDaneOKampani(plik);

            MetodaZliczaniaGlosow[] metody = {new MetodaDHondta(), new MetodaSainteLague(), new MetodaHareNiemeyera()};
            Symulacja.symuluj(daneDoSymulacji.getKey(), metody, daneDoSymulacji.getValue());
        } catch (Exception e) {
            throw new FileNotFoundException("Brak pliku");
        }


    }
}
