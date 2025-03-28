package graph;

import java.util.*;

public class DFS {

   private static LinkedList<Integer> [] adj;

    public static void dfsUtil(int startVertex, boolean [] visited){
        System.out.print(startVertex+" ");
        visited[startVertex] = true;
        List<Integer> edges = adj[startVertex];
        if(edges != null) {
            for (Integer edge : edges) {
                if (!visited[edge]) {
                    dfsUtil(edge, visited);
                }
            }
        }
    }

    public static void dfs(int noOfVertex,int startVertex){
        boolean [] visited = new boolean[noOfVertex];
        dfsUtil(startVertex,visited);
    }

    public static void dfsItr(int noOfVertex,int startVertex) {
        boolean[] visited = new boolean[noOfVertex];
        Stack<Integer> st = new Stack<>(); //stack
        st.push(startVertex);

        int top;
        while (!st.isEmpty()){
            top = st.pop();
            visited[top] = true;
            System.out.print(top+" ");
            List<Integer> edges = adj[top];
            if(edges != null){
                for(Integer edge : edges){
                    if(!visited[edge]){
                        visited[edge] = true;
                        st.push(edge);
                    }
                }
            }
        }
    }

    /*
    * 0->1->2
    * 1->2
    * 2->0->3
    * 3->3
    * */
    public static void main(String[] args) {
        int totalVertex = 5;
        AdjacencyMatrix adjObj =  new AdjacencyMatrix(totalVertex);
        adj = adjObj.getAdj();

        adjObj.addEdge(0, 1);
        adjObj.addEdge(0, 2);
        adjObj.addEdge(1, 2);
        adjObj.addEdge(1, 0);
        adjObj.addEdge(2, 0);
        adjObj.addEdge(2, 1);
        adjObj.addEdge(2, 3);
        adjObj.addEdge(2, 4);
        adjObj.addEdge(3, 2);
        adjObj.addEdge(4, 4);

        int startVertex = 0;

        System.out.println("Following is Depth First Traversal (starting from vertex ) "+startVertex);

        dfs(totalVertex,startVertex);
        System.out.println("\nitr approach ");
        dfsItr(totalVertex,startVertex);
    }
}
