public class QuickFindTree implements UnionFind {

    private Node<?> radix;
    private int size = 0;

    public QuickFindTree(Elem<?> firstElem) {
        makeSet(firstElem);
    }

    // MAKESET
    // the element and the node must have the same type
    public void makeSet(Elem<?> firstElem) {

        Node<?> firstNode = new Node<>(firstElem);

        this.radix = new Node<>(firstNode.getElem());
        this.radix.setFather(null);

        firstNode.setFather(this.radix);
        this.radix.addSon(firstNode);

        firstNode.deleteSons();
        size++;

        elements.put(firstElem, firstNode);

    }

    public Node<?> getRadix() {
        return radix;
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
                "radix=" + radix +
                ", size=" + size +
                ", sons= {" + radix.getSons() +
                '}';
    }
}
