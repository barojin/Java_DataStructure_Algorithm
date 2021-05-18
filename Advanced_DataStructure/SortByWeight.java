package DSA.Advanced_DataStructure;

import java.util.Comparator;

class SortByWeight implements Comparator<MinimumSpanningTree.Edge> {
    @Override
    public int compare(MinimumSpanningTree.Edge o1, MinimumSpanningTree.Edge o2) {
        return o1.weight - o2.weight;
    }
}
