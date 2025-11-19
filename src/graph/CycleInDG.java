package graph;

import java.util.LinkedList;

public class CycleInDG {

    private static LinkedList<Integer>[] adj;
    private  static boolean [] visited;
    private static boolean [] recStackArr;

    public static void main(String[] args) {
        int totalVertex = 4;
        AdjacencyList adjObj = new AdjacencyList(totalVertex);
        adj = adjObj.getAdj();

        adjObj.addEdge(0, 1);
        adjObj.addEdge(0, 2);
        adjObj.addEdge(1, 2);
        adjObj.addEdge(2, 0);
        adjObj.addEdge(2, 3);
        adjObj.addEdge(3, 3);

        System.out.println(isCycleInDG(totalVertex));
    }

    public static boolean isCycleInDG(int totalVertex) {
        visited = new boolean[totalVertex];
        recStackArr = new boolean[totalVertex];
        for(int i=0;i<totalVertex;i++){
            if(isCycleUtil(i)){
                return true;
            }
        }
        return false;
    }

    public CycleInDG(LinkedList<Integer>[] adj){
        this.adj = adj;
    }

    private static boolean isCycleUtil(int i) {
        if(recStackArr[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }
        recStackArr[i] = true;
        visited[i] = true;
        LinkedList<Integer> adjList = adj[i];
        if(adjList != null) {
            for (int v : adjList) {
                if (isCycleUtil(v)) {
                    return true;
                }
            }
        }
        recStackArr[i] = false;
        return false;
    }

}
