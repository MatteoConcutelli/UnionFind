import java.util.HashMap;
import java.util.Map;

public interface UnionFind {

    // for the find :
    // element <-> node
    Map<Elem<?>, QuickFindTree.Node<?>> elements = new HashMap<>();

    static QuickFindTree union(QuickFindTree A, QuickFindTree B){

        if ( A.getSize() >= B.getSize()) {
            for (QuickFindTree.Node<?> node : B.getRoot().getSons()) {
                node.setFather(A.getRoot());
                A.getRoot().addSon(node);
            }

            B.getRoot().deleteSons();
            A.setSize(A.getSize()+B.getSize());

            return A;
        }
        else {
            for (QuickFindTree.Node<?> node : A.getRoot().getSons()) {
                node.setFather(B.getRoot());
                B.getRoot().addSon(node);
            }

            A.getRoot().deleteSons();
            B.setSize(A.getSize()+B.getSize());

            return B;
        }
    }  // return a tree that represent the union of A and B

    // make a set of 1 element (a tree with radix and leaf nodes, equals)
    // the radix represent the set
    // the foil is the first element of the made set
    void makeSet(Elem<?> elem);
    // TODO: 17/04/2022 make makeSet static (default)

    // return the father of the element associated node
    static QuickFindTree.Node<?> find(Elem<?> elem){
        return elements.get(elem).getFather();
    }


}
