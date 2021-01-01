package graph;

import java.util.Deque;
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

    public static void dfsItr(int noOfVertex,int startVertex) {
        boolean[] visited = new boolean[noOfVertex];
        Deque<Integer> st = new LinkedList<>(); //stack
        st.addLast(startVertex);

        int top;
        int node;
        while (!st.isEmpty()){
            top = st.removeLast();
            visited[top] = true;
            System.out.print(top+" ");
            Iterator<Integer> itr = adj[top].iterator();
            while (itr.hasNext()){
                node = itr.next();
                if(!visited[node]){
                    st.addLast(node);
                }
            }
        }
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
        System.out.println("\nitr approach ");
        dfsItr(totalVertex,startVertex);
    }
}
