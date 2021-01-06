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

        System.out.println("using BFS ");
        topoLogicalSort(totalVertex);
        System.out.println("\nusing kahn's algo");
        kahnsAlgo(totalVertex);
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

    /*
    * calculate indegree of each node
    *
    * */
    public static void kahnsAlgo(int totalVertex){

        int [] inDegree = new int[totalVertex]; // initialize 0
        calculateInDegree(inDegree,totalVertex);

        //enqueue node whose in-degree is 0
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<totalVertex;i++){
            if(inDegree[i] == 0){
                qu.offer(i);
            }
        }

        int count=0;
        ArrayList<Integer> resulList = new ArrayList<>();
        Integer queueNode;
        while (!qu.isEmpty()){
            queueNode = qu.poll();
            resulList.add(queueNode);

            Iterator<Integer> adjNodes = adj[queueNode].iterator();
            while (adjNodes.hasNext()){
                Integer node = adjNodes.next();
                if(--inDegree[node] == 0){
                    qu.offer(node);
                }
            }
            count++;
        }
        if(count != totalVertex){
            System.out.println("cycle is exist ");
            return;
        }
        System.out.println(resulList.toString());

    }

    private static void calculateInDegree(int[] inDegree,int totalVertex) {

        for(int i=0;i<totalVertex;i++){
            Iterator<Integer> it = adj[i].iterator();
            while (it.hasNext()){
                inDegree[it.next()]++;
            }
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
