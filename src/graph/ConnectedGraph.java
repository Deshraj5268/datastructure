package graph;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/number-of-provinces/
public class ConnectedGraph {



    public static void main(String[] args) {
        ConnectedGraph connectedGraph = new ConnectedGraph();
        int [][][] cities = { {{1,1,0}, {1,1,0},{0,0,1}}
                             ,{{1,0,0}, {0,1,0}, {0,0,1}}
                            };
        for(int i=0;i<cities.length;i++) {
            int totalConnectedCity = connectedGraph.findCircleNum(cities[i]);
            System.out.println(totalConnectedCity);
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<isConnected.length;i++){
            if(!visited.contains(i)){
                dfs(isConnected, i, visited);
                province++;
            }
        }
        return province;
    }

    public void dfs(int [][] isConnected, int i,Set<Integer> visited){
        visited.add(i);
        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j] == 1 && !visited.contains(j)){
                dfs(isConnected, j, visited);
            }
        }

    }
}
