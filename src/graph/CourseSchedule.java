package graph;

import graph.disjointset.DisJointOps;

import java.util.*;

/*
* https://leetcode.com/problems/course-schedule/description/
* */
public class CourseSchedule {

    public static void main(String[] args) {
        int [][][] prerequisites = {
                {{0,1},{1,0}},
                {{1,4},{2,4},{3,1},{3,2}},
                {{1,0}},
                {{0,1},{0,2},{1,3},{1,4},{3,4}},
                {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}

        };
        int [] courses = {2,5,2,5,20};
        boolean [] output = {false,true,true,true,false};
        for(int i=0;i<prerequisites.length;i++){
            boolean result = canFinish(courses[i],prerequisites[i]);
            //System.out.println(Arrays.toString(prerequisites[i]));
            System.out.println("result :"+result);
        }
    }



    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
        if (visited[curr] == 2) {
            return true;
        }

        visited[curr] = 2;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (visited[adj.get(curr).get(i)] != 1) {
                if (isCyclic(adj, visited, adj.get(curr).get(i))) {
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    }

    /*
    * pre pare adjList
    * (a,b) --> [a->b]
    * */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> [] adj = new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }
        // prepare adjList
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        List<Integer> result = topoLogicalSort(adj,  numCourses);
        return result.size() == numCourses;

    }

    public static List<Integer> topoLogicalSort(List<Integer>[] adj, int numCourses){
        // Topological sort -- Kahan's algo
        //calculate indegree

        int [] inDegree = new int[numCourses];
        for(int i=0;i<adj.length;i++){
            for(Integer edge : adj[i]){
                inDegree[edge]++;
            }
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }

        Integer node;
        List<Integer> result = new LinkedList<>();
        while(!pq.isEmpty()){
            node = pq.poll();
            result.add(node);

            for(Integer edge : adj[node]){
                if(--inDegree[edge] == 0){
                    pq.add(edge);
                }
            }
        }
        return result;
    }

    /* public static boolean canFinish(int numCourses, int[][] prerequisites){
       // Map<Integer, List<Integer>> map = prepareCourseMap(prerequisites);
        LinkedList<Integer>[] adj = prepareAdjList(prerequisites,numCourses);
        CycleInDG cycleInDG = new CycleInDG(adj);
        return !CycleInDG.isCycleInDG(numCourses);
       // TopologicalSort.kahnsAlgo(numCourses,adj);
       *//* List<Integer> result = TopologicalSort.kahnsAlgo(numCourses,adj);
        *//**//*int [] inDegree = TopologicalSort.calculateInDegree(numCourses,adj);
        Queue<Integer> qu = TopologicalSort.getIndegrees(numCourses,inDegree);
        return qu.size() != 0;*//**//*
        System.out.print("result list : "+result.toString()+"\n");
        return result.size() != 0 && result.size() == numCourses;*//*
    }*/

    private static  LinkedList<Integer>[] prepareAdjList(int[][] prerequisites,int numCourses) {
        LinkedList<Integer> [] adj = new LinkedList[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            LinkedList<Integer> newEdges = adj[prerequisites[i][0]];
            if(newEdges == null){
                newEdges = new LinkedList<>();
            }
            newEdges.add(prerequisites[i][1]);
            adj[prerequisites[i][0]] = newEdges;
        }
        return adj;
    }

    private Map<Integer, List<Integer>> prepareCourseMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> courseMappingList;
        for(int i=0;i<prerequisites.length;i++){
            courseMappingList = map.get(prerequisites[i][0]);
            if(courseMappingList == null) {
                courseMappingList = new LinkedList<>();
            }
            courseMappingList.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],courseMappingList);
        }
        return map;
    }

    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] parent = new int[numCourses];
        Arrays.fill(parent,-1);
        int x,y;
        for(int i=0;i<numCourses-1;i++){
            x = DisJointOps.findSet(parent,prerequisites[i][1]);
            y = DisJointOps.findSet(parent,prerequisites[i][0]);
            if(x == y){
                return false;
            }
            DisJointOps.unionSet(parent,x,y);
        }
        return true;
    }*/
}
