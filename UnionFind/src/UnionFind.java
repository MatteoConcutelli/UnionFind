import java.util.HashMap;
import java.util.Map;

public interface UnionFind {

    // for the find :
    // element <-> node
    Map<Elem<?>, Node<?>> elements = new HashMap<>();

    static QuickFindTree union(QuickFindTree A, QuickFindTree B){
        if ( A.getSize() >= B.getSize()) {
            for (Node<?> node : B.getRadix().getSons()) {
                node.setFather(A.getRadix());
                A.getRadix().addSon(node);
            }

            B.getRadix().deleteSons();
            A.setSize(A.getSize()+B.getSize());

            return A;
        }
        else {
            for (Node<?> node : A.getRadix().getSons()) {
                node.setFather(B.getRadix());
                B.getRadix().addSon(node);
            }

            A.getRadix().deleteSons();
            B.setSize(A.getSize()+B.getSize());

            return B;
        }
    }  // return a tree that represent the union of A and B

    void makeSet(Elem<?> elem);
    // make a set of 1 element (a tree with radix and leaf nodes, equals)
    // the radix represent the set
    // the foil is the first element of the made set

    // return the father of the element associated node
    static Node<?> find(Elem<?> elem){
        return elements.get(elem).getFather();
    }


}
