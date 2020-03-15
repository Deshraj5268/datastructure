package graph.disjointset;

public class UDGraph {

    int e;
    int v;
    Edge [] edge;

    public UDGraph(int v,int e){
        this.e = e;
        this.v = v;
        edge = new Edge[e];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }
}
class Edge{
    int src;
    int dest;
}
