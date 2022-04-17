import java.util.ArrayList;
import java.util.List;

public class Node<E> {

    private final Elem<E> elem;

    private Node<?> father;
    public List< Node<?> > sons = new ArrayList<>();

    public Node(Elem<E> elem) {
        this.elem = elem;
    }

    public void setFather(Node<?> father) {
        this.father = father;
    }

    public Node<?> getFather() {
        return father;
    }

    public Elem<E> getElem() {
        return elem;
    }

    @Override
    public String toString() {
        return "{" + elem + '}';
    }
}
