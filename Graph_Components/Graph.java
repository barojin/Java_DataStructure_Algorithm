package DSA.Graph_Components;

import java.util.*;

public class Graph<T>{
    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertices;
    boolean isDirected = false;

    public Graph(boolean isDirected) {
        this.allEdges = new ArrayList<Edge<T>>();
        this.allVertices = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2){
        addEdge(id1, id2, 0);
    }

    public void addVertex(Vertex<T> vertex){
        if (allVertices.containsKey(vertex.getId()))
            return;
        allVertices.put(vertex.getId(), vertex);
        for (Edge<T> edge : vertex.getEdges())
            allEdges.add(edge);
    }

    public Vertex<T> addSingleVertex(long id){
        if(allVertices.containsKey(id)){
            return allVertices.get(id);
        }
        Vertex<T> v = new Vertex<>(id);
        allVertices.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(long id){
        return allVertices.get(id);
    }

    public void addEdge(long id1,long id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertices.containsKey(id1)){
            vertex1 = allVertices.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertices.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertices.containsKey(id2)){
            vertex2 = allVertices.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertices.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertices.values();
    }
    public void setDataForVertex(long id, T data){
        if(allVertices.containsKey(id)){
            Vertex<T> vertex = allVertices.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}