import java.util.ArrayList;
import java.util.List;

public class QuickFindTree implements UnionFind {

    public static class Node<T> {

        private final Elem<T> elem;

        private Node<?> father;
        private final List< Node<?> > sons = new ArrayList<>();


        public Node(Elem<T> elem) {
            this.elem = elem;
        }

        public void setFather(Node<?> father) {
            this.father = father;
        }

        public Node<?> getFather() {
            return father;
        }

        public Elem<T> getElem() {
            return elem;
        }

        public void addSon(Node<?> node) {
            sons.add(node);
        }

        public List<Node<?>> getSons() {
            return sons;
        }

        public void deleteSons () {
            sons.clear();
        }

        @Override
        public String toString() {
            return "{" + elem + '}';
        }

    }

    QuickFindTree.Node<?> root;
    private int size = 0;

    public QuickFindTree(Elem<?> firstElem) {
        makeSet(firstElem);
    }

    // MAKESET
    // the element and the node must have the same type
    public void makeSet(Elem<?> firstElem) {

        Node<?> firstNode = new Node<>(firstElem);

        root = new Node<>(firstNode.getElem());
        root.setFather(null);

        firstNode.setFather(root);
        root.addSon(firstNode);

        firstNode.deleteSons();
        size++;

        elements.put(firstElem, firstNode);

    }

    public Node<?> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "QuickFindTree{" +
                "radix=" + root +
                ", size=" + size +
                ", sons= {" + root.getSons() +
                '}';
    }
}
