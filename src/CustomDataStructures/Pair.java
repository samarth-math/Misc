package CustomDataStructures;

public class Pair<T, X> {
    public final T fst;
    public final X snd;

    public Pair(T t, X x) {
        this.fst = t;
        this.snd = x;
    }

    public static Pair<Integer, Integer> of(Integer t, Integer x) {
        return new Pair<Integer, Integer>(t, x);
    }
}
