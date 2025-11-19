package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private static LinkedList<Integer> [] adj;

    public static void bfsUtil(int startVertex,boolean [] visited){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(startVertex);
        visited[startVertex] = true;
       // int newVertex;
        int queueddata;
        while (!qu.isEmpty()){
            queueddata = qu.poll();
            System.out.print(queueddata+" ");
            List<Integer> edges = adj[queueddata];
            if(edges != null) {
                for (int newVertex : edges) {
                    if (!visited[newVertex]) {
                        visited[newVertex] = true;
                        qu.offer(newVertex);
                    }
                }
            }
        }
    }

    public static void bfs(int noOfVertex,int startVertex){
        boolean [] visited = new boolean[noOfVertex];
        bfsUtil(startVertex,visited);
    }

    public static void main(String[] args) {
            int totalVertex = 4;
            AdjacencyList adjObj =  new AdjacencyList(totalVertex);
            adj = adjObj.getAdj();

            adjObj.addEdge(0, 1);
            adjObj.addEdge(0, 2);
            adjObj.addEdge(1, 2);
            adjObj.addEdge(2, 0);
            adjObj.addEdge(2, 3);
            adjObj.addEdge(3, 3);

            int startVertex = 2;

            System.out.println("Following is Depth First Traversal (starting from vertex )"+startVertex);

            bfs(totalVertex,startVertex);
    }
}
