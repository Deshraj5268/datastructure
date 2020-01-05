package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

   private static LinkedList<Integer> [] adj;

    public static void dfsUtil(int startVertex, boolean [] visited){
        System.out.print(startVertex+" ");
        visited[startVertex] = true;
        Iterator<Integer> it = adj[startVertex].iterator();
        int newVertex;
        while (it.hasNext()){
            newVertex = it.next();
            if(!visited[newVertex]){
                dfsUtil(newVertex,visited);
            }
        }
    }

    public static void dfs(int noOfVertex,int startVertex){
        boolean [] visited = new boolean[noOfVertex];
        dfsUtil(startVertex,visited);
    }

    public static void main(String[] args) {
        int totalVertex = 4;
        AdjacencyMatrix adjObj =  new AdjacencyMatrix(totalVertex);
        adj = adjObj.getAdj();

        adjObj.addEdge(0, 1);
        adjObj.addEdge(0, 2);
        adjObj.addEdge(1, 2);
        adjObj.addEdge(2, 0);
        adjObj.addEdge(2, 3);
        adjObj.addEdge(3, 3);

        int startVertex = 2;

        System.out.println("Following is Depth First Traversal (starting from vertex )"+startVertex);

        dfs(totalVertex,startVertex);
    }
}
