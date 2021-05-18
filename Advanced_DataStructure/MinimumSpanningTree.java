package DSA.Advanced_DataStructure;

import DSA.Graph_Components.Graph;
import DSA.Graph_Components.Vertex;

import java.util.*;

public class MinimumSpanningTree {
    class Edge{
        int src, dest, weight;

        public Edge(){};

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    int N, M;

    public MinimumSpanningTree(int n, int m) {
        this.N = n;
        this.M = m;
    }

    /*
    * Kruskal's algorithm
    * The steps for implementing Kruskal's algorithm are as follows:
    * 1. Sort all the edges from low weight to high
    * 2. Take the edge with the lowest weight and add it to the spanning tree. If adding the edge created a cycle, then reject this edge.
    * 3. Keep adding edges until we reach all vertices.
    * */
    public ArrayList<Edge> Kruskal(Edge[] edges){
        ArrayList<Edge> result = new ArrayList<>();
        int minimumCost = 0;
        DisjointSetUnion dsu = new DisjointSetUnion(this.N);

        for (int i = 0; i < N; i++) {
            dsu.make_set(i);
        }

        Arrays.sort(edges, new SortByWeight());
        for (Edge e : edges){
            // If they are in the same set, it makes cycle, so don't add it
            if (dsu.find_set(e.src) != dsu.find_set(e.dest)){
                minimumCost += e.weight;
                result.add(e);
                dsu.union_sets(e.src, e.dest);
            }
        }
        System.out.println("Minimum cost= " + minimumCost);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 6;
        int m = 8;
        MinimumSpanningTree MST = new MinimumSpanningTree(n, m);
        Edge[] edges = new Edge[m];
        edges[0] = MST.new Edge(0, 1, 4);
        edges[1] = MST.new Edge(0, 2, 4);
        edges[2] = MST.new Edge(1, 2, 2);
        edges[3] = MST.new Edge(2, 3, 3);
        edges[4] = MST.new Edge(2, 5, 2);
        edges[5] = MST.new Edge(2, 4, 4);
        edges[6] = MST.new Edge(3, 4, 3);
        edges[7] = MST.new Edge(5, 4, 3);
        ArrayList<Edge> result = MST.Kruskal(edges);
        System.out.println(result.toString());
    }
}
