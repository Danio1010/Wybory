package cover;

public class Dzialanie {
    private int[] dzialanie;
    public Dzialanie(int[] dzialanie) {
        this.dzialanie = dzialanie;
    }

    public int[] dajDzialanie() {
        return dzialanie;
    }

    public int dajWartoscBezwzgledna() {
        int res = 0;
        for (Integer value : dzialanie) {
            res += Math.abs(value);
        }

        return res;
    }
}
