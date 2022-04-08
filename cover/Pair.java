package cover;

public class Pair<T,T2> {
    private T key;
    private T2 value;

    public Pair(T t, T2 t2) {
        this.key = t;
        this.value = t2;
    }

    public T getKey() {
        return this.key;
    }

    public T2 getValue() {
        return this.value;
    }
}
