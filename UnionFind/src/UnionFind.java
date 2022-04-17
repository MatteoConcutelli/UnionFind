


// TODO: 17/04/2022 delete the object A or B after the union

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    // for the find :
    // element <-> node
    Map<Elem<?>, Node<?>> elements = new HashMap<>();

    // UNION
    public QuickFindTree union(QuickFindTree A, QuickFindTree B) {

        if ( A.getSize() >= B.getSize()) {
            for (Node<?> node : B.getRadix().sons) {
                node.setFather(A.getRadix());
                A.getRadix().sons.add(node);
            }

            B.getRadix().sons.clear();
            A.setSize(A.getSize()+B.getSize());

            return A;
        }
        else {
            for (Node<?> node : A.getRadix().sons) {
                node.setFather(B.getRadix());
                B.getRadix().sons.add(node);
            }

            A.getRadix().sons.clear();
            B.setSize(A.getSize()+B.getSize());

            return B;
        }

    }

    // MAKESET
    // the element and the node must have the same type
    public <E> QuickFindTree makeSet(Elem<E> elem) {

        Node<E> node = new Node<>(elem);
        elements.put(elem, node);

        return new QuickFindTree(node);
    }

    // FIND
    public Node<?> find(Elem<?> elem) {
        return elements.get(elem).getFather();
    }

}


