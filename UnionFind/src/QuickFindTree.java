public class QuickFindTree {

    private final Node<?> radix;
    private int size = 0;

    public QuickFindTree(Node<?> firstNode) {

        this.radix = new Node<>(firstNode.getElem());
        this.radix.setFather(null);

        firstNode.setFather(this.radix);
        this.radix.sons.add(firstNode);

        firstNode.sons.clear();
        size++;
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
                ", sons= {" + radix.sons +
                '}';
    }
}
