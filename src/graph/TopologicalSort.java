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
        List<Integer> resulList = kahnsAlgo(totalVertex,adj);
        if(resulList.size() != totalVertex){
            System.out.println("cycle is exist ");
            return;
        }
        System.out.println(resulList.toString());
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
    public static  List<Integer> kahnsAlgo(int totalVertex,LinkedList<Integer>[] adj){

        int [] inDegree = calculateInDegree(totalVertex,adj);
        Queue<Integer> qu = getIndegrees(totalVertex, inDegree);
        List<Integer> resulList = getTopologicalOrderedNodes(qu,inDegree,adj);
        /*if(resulList.size() != totalVertex){
            System.out.println("cycle is exist ");
            return;
        }
        System.out.println(resulList.toString());*/
        return resulList;
    }

    public static Queue<Integer> getIndegrees(int totalVertex, int[] inDegree) {
        //enqueue node whose in-degree is 0
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i< totalVertex; i++){
            if(inDegree[i] == 0){
                qu.offer(i);
            }
        }
        return qu;
    }

    public static List<Integer> getTopologicalOrderedNodes(Queue<Integer> qu,int [] inDegree,LinkedList<Integer>[] adj){
        ArrayList<Integer> resulList = new ArrayList<>();
        Integer queueNode;
        while (!qu.isEmpty()){
            queueNode = qu.poll();
            resulList.add(queueNode);

            if(adj[queueNode] != null) {
                Iterator<Integer> adjNodes = adj[queueNode].iterator();
                while (adjNodes.hasNext()) {
                    Integer node = adjNodes.next();
                    if (inDegree[node] != -1 && --inDegree[node] == 0) {
                        qu.offer(node);
                    }
                }
            }
        }
        return resulList;
    }

    public static int[] calculateInDegree(int totalVertex,LinkedList<Integer>[] adj) {
        int[] inDegree = new int[totalVertex];
        //Arrays.fill(inDegree,-1);
        for(int i=0;i<totalVertex;i++){
            if(adj[i]!=null) {
                Iterator<Integer> it = adj[i].iterator();
                while (it.hasNext()) {
                    int val = it.next();
                    if(inDegree[val] == -1){
                        inDegree[val] = 0;
                    }
                    inDegree[val]++;
                }
            }else{
                if(inDegree[i]<1)
                inDegree[i] = -1;
            }
        }
        return inDegree;
    }


    private static void topoLogicalSortUtil(int vertex, boolean [] visited, Deque<Integer> stack){
        visited[vertex] = true;
        if(adj[vertex] != null) {
            Iterator<Integer> nodeItr = adj[vertex].iterator();
            int node;
            while (nodeItr.hasNext()) {
                node = nodeItr.next();
                if (!visited[node]) {
                    topoLogicalSortUtil(node, visited, stack);
                }
            }
        }
        stack.addFirst(vertex);
    }
}
