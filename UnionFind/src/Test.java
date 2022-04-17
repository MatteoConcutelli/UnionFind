import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Elem<?>> elements = new ArrayList<>();

        elements.add(new Elem<>("Hello"));
        elements.add(new Elem<>(1234));
        elements.add(new Elem<>("beautiful"));
        elements.add(new Elem<>("world"));

        QuickFindTree set1 = new QuickFindTree(elements.get(0));
        QuickFindTree set2 = new QuickFindTree(elements.get(1));

        QuickFindTree A = UnionFind.union(set1, set2);

        QuickFindTree set3 = new QuickFindTree(elements.get(2));
        QuickFindTree set4 = new QuickFindTree(elements.get(3));

        QuickFindTree B = UnionFind.union(set3, set4);

        /* FIND */ System.out.println(UnionFind.find(elements.get(1)));

        System.out.println(UnionFind.union(A,B));

    }
}
