package DSA.Advanced_DataStructure;

import java.util.Arrays;

public class DisjointSetUnion {
    int[] parent;
    int[] rank;

    public DisjointSetUnion(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        Arrays.fill(rank, 0);
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public void setRank(int[] rank) {
        this.rank = rank;
    }

    void make_set(int v){
        parent[v] = v;
        rank[v] = 0;
    }

    int find_set(int v){
        if (v == parent[v])
            return v;
        return parent[v] = find_set(parent[v]);
    }

    void union_sets(int a, int b){
        a = find_set(a);
        b = find_set(b);
        if (a != b){
            if (rank[a] < rank[b]){
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        }
    }
}
