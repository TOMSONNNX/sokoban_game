/**
 * Klasa grupujaca dwie wspolrzedne
 * @param <A>
 * @param <B>
 */
public class Pair<A, B> {
    public A a;
    public final B b;

    /**
     * Konstruktor
     * @param a1
     * @param b1
     */
    public Pair(A a1, B b1) {
        this.a = a1;
        this.b = b1;
    }
}
