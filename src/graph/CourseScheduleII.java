package graph;

import java.util.*;

public class CourseScheduleII {
    List<List<Integer>> adj;
    boolean [] visited;// = new boolean[totalVertex];
    boolean[]  recStackArr ;


    public static void main(String[] args) {
        int [][][] prerequisites = {
                {{0,1},{1,0}},
                {{1,4},{2,4},{3,1},{3,2}},
                {{1,0}},
                {{0,1},{0,2},{1,3},{1,4},{3,4}},
                {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}

        };
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int [] courses = {2,5,2,5,20};
        boolean [] output = {false,true,true,true,false};
        for(int i=0;i<prerequisites.length;i++){
            int [] result = courseScheduleII.findOrder(courses[i],prerequisites[i]);
            System.out.print("input : ");
           for(int j=0;j<prerequisites[i].length;j++) {
               System.out.print(Arrays.toString(prerequisites[i][j]));
               System.out.print(",");
           }
            System.out.println();
            System.out.println("result :"+ Arrays.toString(result));
        }
    }
    public int[] findOrder(int n, int[][] pair) {
        adj = prepareAdjList(n,pair);
        if(isCycleInDG(n)){
            return new int[0];//empty list
        }
        int [] result = topologicalOrder(n);
        return result;
    }

    public List<List<Integer>> prepareAdjList(int n,int [][] pair){
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pair.length;i++){
            adj.get(pair[i][0]).add(pair[i][1]);
        }
        return adj;
    }
    public int [] topologicalOrder(int v){
        Deque<Integer> stack = new LinkedList<>();
        boolean [] visited = new boolean[v];
        for(int vertex=0;vertex<v;vertex++){
            if(!visited[vertex]){
                topologicalOrderUtil(vertex,stack,visited);
            }
        }
        int [] result = new int[stack.size()];
        int index=0;
        while(!stack.isEmpty()){
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    public void topologicalOrderUtil(int vertex,Deque<Integer> stack,boolean [] visited){

        visited[vertex] = true;
        List<Integer> edges = adj.get(vertex);
        for(int node:edges){
            if(!visited[node]){
                topologicalOrderUtil(node,stack,visited);
            }
        }
        stack.add(vertex);
    }

    public  boolean isCycleInDG(int totalVertex) {
        visited = new boolean[totalVertex];
        recStackArr = new boolean[totalVertex];
        for(int i=0;i<totalVertex;i++){
            if(isCycleUtil(i)){
                return true;
            }
        }
        return false;
    }

    private  boolean isCycleUtil(int i) {
        if(recStackArr[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }
        recStackArr[i] = true;
        visited[i] = true;
        List<Integer> adjList = adj.get(i);
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
