package DSA.Advanced_DataStructure;

import java.util.ArrayList;
public class UnionFind {
    class Node{
        int size;
        int rank;
        int value;

        public Node(int value) {
            this.size = 1;
            this.rank = 0;
            this.value = value;
        }
    }

    ArrayList<Node> parent;

    public UnionFind(int n) {
        this.parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(new Node(i));
        }
    }

    // Path compression,
    // makes every node between the query node and the root
    // point to the root
    public int find(int v){
        if (v == parent.get(v).value)
            return v;
        else{
            return parent.get(v).value = find(parent.get(v).value);
        }
    }

    public void union_bySize(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b){
            if (parent.get(a).size < parent.get(b).size){
                int temp = a;
                a = b;
                b = temp;
            }
            parent.get(b).value = a;
            parent.get(a).size += parent.get(b).size;
        }
    }
}
