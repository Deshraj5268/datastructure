package graph;

import java.util.*;

public class TopologicalSort {

    private static LinkedList<Integer>[] adj;

    public static void main(String[] args) {
        int totalVertex = 6;
        AdjacencyMatrix adjObj = new AdjacencyMatrix(totalVertex);
        adj = adjObj.getAdj();

        adjObj.addEdge(5, 2);
        adjObj.addEdge(5, 0);
        adjObj.addEdge(4, 0);
        adjObj.addEdge(4, 1);
        adjObj.addEdge(2, 3);
        adjObj.addEdge(3, 1);

        topoLogicalSort(totalVertex);
    }


    /*
    * Use Modified  DFS : call dfs for all disconnected graph
    * don't print vertex immediately
    * first we call topoLogicalSort for all adjacent node and store in temp stack
    *
    *
    * */
    public static void topoLogicalSort(int totalVertex){

        boolean [] visited = new boolean[totalVertex];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<totalVertex;i++){
            if(!visited[i]) {
                topoLogicalSortUtil(i,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.removeFirst()+" ");
        }
    }

    private static void topoLogicalSortUtil(int vertex, boolean [] visited, Deque<Integer> stack){
        visited[vertex] = true;
        Iterator<Integer> nodeItr = adj[vertex].iterator();
        int node;
        while (nodeItr.hasNext()){
            node = nodeItr.next();
            if(!visited[node]){
                topoLogicalSortUtil(node,visited,stack);
            }
        }
        stack.addFirst(vertex);
    }
}
