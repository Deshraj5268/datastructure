package graph;

import java.util.LinkedList;

public class AdjacencyMatrix {

    LinkedList<Integer> [] adj;

    public AdjacencyMatrix(int vertex){
        adj = new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int vertex,int w){
        adj[vertex].add(w);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
