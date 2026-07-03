package graph.topologicalproblem;

import java.util.*;

// asked in company
public class PackageBuildOrder {

    public static void main(String[] args) {
        // Multiple package test cases
        String[][] allPackages = {
                {"P1", "P2", "P3"},
                {"P1", "P2"},
                {"P0", "P1", "P2", "P3"},
                {"P1", "P2", "P3"}
        };

        // Multiple dependency test cases
        String[][][] allDependencies = {
                {{"P1", "P2"}, {"P2", "P3"}},
                {// No dependency
                },
                {{"P2", "P0"}, {"P1", "P2"}, {"P3", "P1"}, {"P3", "P2"}},
                {{"P1", "P2"}, {"P2", "P3"}, {"P3", "P1"}}
        };

        // Run all test cases
        for (int i = 0; i < allPackages.length; i++) {
            System.out.println("\nTest Case " + (i + 1));
            List<String> order = findBuildOrder(allPackages[i], allDependencies[i]);
            System.out.println(order);
        }
    }

    public static List<String> findBuildOrder(String [] packages, String [][] dependencies) {
        Map<String, List<String>> adjGraphMap = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        for(String pkg : packages){
            adjGraphMap.put(pkg, new ArrayList<>());
            inDegree.put(pkg, 0);
        }

        //build graph
        String from, to;
        for(String [] dependency : dependencies){
            from = dependency[0];
            to = dependency[1];
            adjGraphMap.get(from).add(to);
            inDegree.put(to, inDegree.get(to) + 1); // indegree clc
        }

        // Add indegree 0 nodes
        for(String pkg : packages){
            if(inDegree.get(pkg) == 0){
                queue.add(pkg);
            }
        }

        String current;
        while (!queue.isEmpty()){
            current = queue.poll();
            result.add(current);

            List<String> edges = adjGraphMap.get(current);
            for(String edge : edges){
                inDegree.put(edge, inDegree.get(edge)-1);
                if(inDegree.get(edge) == 0){
                    queue.add(edge);
                }
            }

        }
        // cycle detection
        if(result.size() != packages.length){
            return new ArrayList<>();
        }
        return result;
    }
}
