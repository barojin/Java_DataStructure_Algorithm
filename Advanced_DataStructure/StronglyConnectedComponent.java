package DSA.Advanced_DataStructure;

import DSA.Graph_Components.Edge;
import DSA.Graph_Components.Vertex;
import DSA.Graph_Components.Graph;

import java.util.*;

public class StronglyConnectedComponent {

    public List<List<Vertex<Integer>>> scc(Graph<Integer> graph){
        Deque<Vertex<Integer>> dq = new ArrayDeque<>();
        Set<Vertex<Integer>> visited = new HashSet<>();

        for (Vertex<Integer> v : graph.getAllVertex()){
            if (!visited.contains(v))
                dfs(v, visited, dq);
        }

        Graph<Integer> revG = reverseGraph(graph);

        visited.clear();
        List<List<Vertex<Integer>>> result = new ArrayList<>();
        while (!dq.isEmpty()){
            Vertex<Integer> vertex = revG.getVertex(dq.poll().getId());
            if(visited.contains(vertex))
                continue;

            ArrayList<Vertex<Integer>> list = new ArrayList<>();
            dfs_rev(vertex, visited, list);
            result.add(list);
        }
        return result;
    }

    private Graph<Integer> reverseGraph(Graph<Integer> graph){
        Graph<Integer> revG = new Graph<>(true);
        for (Edge<Integer> edge : graph.getAllEdges()){
            revG.addEdge(edge.getVertex2().getId(), edge.getVertex1().getId(), edge.getWeight());
        }
        return revG;
    }

    private void dfs(Vertex<Integer> vertex, Set<Vertex<Integer>> visited, Deque dq){
        visited.add(vertex);
        for (Vertex v : vertex.getAdjacentVertex()){
            if (!visited.contains(v))
                dfs(v, visited, dq);
        }
        dq.offerFirst(vertex);
    }

    private void dfs_rev(Vertex<Integer> vertex,
                         Set<Vertex<Integer>> visited, List<Vertex<Integer>> set){
        visited.add(vertex);
        set.add(vertex);
        for (Vertex v : vertex.getAdjacentVertex()){
            if (visited.contains(v))
                continue;
            dfs_rev(v, visited, set);
        }
    }
    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);

        StronglyConnectedComponent scc = new StronglyConnectedComponent();
        List<List<Vertex<Integer>>> result = scc.scc(graph);

        //print the result
        result.forEach(set -> {
            set.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });
    }
}
