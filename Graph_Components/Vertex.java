package DSA.Graph_Components;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T>{
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id){
        this.id = id;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }

    public int getDegree(){
        return edges.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public List<Vertex<T>> getAdjacentVertex() {
        return adjacentVertex;
    }

    public void setAdjacentVertex(List<Vertex<T>> adjacentVertex) {
        this.adjacentVertex = adjacentVertex;
    }
}
