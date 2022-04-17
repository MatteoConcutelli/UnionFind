public class Elem<T> {

    T elem;

    public Elem (T elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "Elem{" + elem +
                '}';
    }
}
