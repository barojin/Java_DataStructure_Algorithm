package DSA.Advanced_DataStructure;

import java.util.*;
public class Dijkstra {
    class Node implements Comparator<Node>{
        int node;
        int cost;
        public Node(){}

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    int d[];
    Set<Integer> visited;
    PriorityQueue<Node> pqueue;
    int N;
    List<List<Node>> adj_list;

    public Dijkstra(int N) {
        this.N = N;
        d = new int[N];
        visited = new HashSet<Integer>();
        pqueue = new PriorityQueue<Node>(N, new Node());
    }

    public void algorithm(List<List<Node>> adj_list, int src){
        this.adj_list = adj_list;

        Arrays.fill(d, Integer.MAX_VALUE);
        pqueue.add(new Node(src, 0));
        d[src] = 0;
        while(visited.size() != N){
            int u = pqueue.poll().node;
            visited.add(u);
            graph_adjacentNodes(u);
        }
    }

    private void graph_adjacentNodes(int u)   {
        for (int i = 0; i < adj_list.get(u).size(); i++) {
            Node v = adj_list.get(u).get(i);
            if(!visited.contains(v.node)) {
                int newDistance = d[u] + v.cost;
                if (newDistance < d[v.node])
                    d[v.node] = newDistance;
                pqueue.add(new Node(v.node, d[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int source = 0;
        // adjacency list representation of graph
        List<List<Node> > adj_list = new ArrayList<>();
        // Initialize adjacency list for every node in the graph
        for (int i = 0; i < V; i++) {
            adj_list.add(new ArrayList<Node>());
        }
        Dijkstra dpq = new Dijkstra(V);

        // Input graph edges
        adj_list.get(0).add(dpq.new Node(1, 5));
        adj_list.get(0).add(dpq.new Node(2, 3));
        adj_list.get(0).add(dpq.new Node(3, 2));
        adj_list.get(0).add(dpq.new Node(4, 3));
        adj_list.get(0).add(dpq.new Node(5, 3));
        adj_list.get(2).add(dpq.new Node(1, 2));
        adj_list.get(2).add(dpq.new Node(3, 3));
        // call Dijkstra's algo method

        dpq.algorithm(adj_list, source);

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.d.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.d[i]);
    }
}