package DSA.Graph_Components;

public class Edge <T>{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }

    public Vertex<T> getVertex1(){
        return vertex1;
    }

    public Vertex<T> getVertex2(){
        return vertex2;
    }

    public int getWeight(){
        return weight;
    }

    public boolean isDirected(){
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}
