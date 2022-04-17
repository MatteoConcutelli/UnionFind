import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Elem<?>> elements = new ArrayList<>();

        elements.add(new Elem<>("Hello"));
        elements.add(new Elem<>(1234));
        elements.add(new Elem<>("beautiful"));
        elements.add(new Elem<>("world"));

        UnionFind unionFind = new UnionFind();

        QuickFindTree set1 = unionFind.makeSet(elements.get(0));
        QuickFindTree set2 = unionFind.makeSet(elements.get(1));

        QuickFindTree A = unionFind.union(set1,set2);

        QuickFindTree set3 = unionFind.makeSet(elements.get(2));
        QuickFindTree set4 = unionFind.makeSet(elements.get(3));

        QuickFindTree B = unionFind.union(set3,set4);

        QuickFindTree C = unionFind.union(A, B);
        // QuickFindTree C = unionFind.union(set1, set3);

        /* FIND :*/ System.out.println(unionFind.find(elements.get(2)));
        System.out.println(C);

    }
}
