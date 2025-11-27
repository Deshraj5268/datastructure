package graph.disjointset;

import java.util.Arrays;


//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
//https://leetcode.com/discuss/post/655708/graph-for-beginners-problems-pattern-sam-06fb/ all problem

// https://www.youtube.com/watch?v=8f1XPm4WOUc : good one
public class MinEdgeToConnectNetwork {

    public static void main(String[] args) {

        int [][][] graphs = {{{0,1},{0,2},{1,2}},
                {{0,1},{0,2},{0,3},{1,2},{1,3}},
                {{0,1},{0,2},{0,3},{1,2}},
                {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}}

        };
        int[] totalComp = {4, 6, 6, 12};

        for(int i=0;i<graphs.length;i++){
            int edgeCountToConnectedComp = makeConnected(totalComp[i], graphs[i]);
            System.out.println(edgeCountToConnectedComp);
        }

    }

    public static int makeConnected(int n, int[][] connections) {
        // To connect n nodes, we need at least n - 1 edges
        if(connections.length < n-1){
            return -1;
        }
        int [] parent = new int[n]; /// N+1 so start 0
        Arrays.fill(parent , -1);
        for(int i=0;i<connections.length;i++){
            int src = DisJointOps.findSet(parent , connections[i][0]);
            int dst = DisJointOps.findSet(parent , connections[i][1]);

            if(src != dst){
                DisJointOps.unionSet(parent, src,dst); // we connect the edge so we can decrease the total nodes
                n--;
            }
        }

        return n-1; // node start with 0
    }
}
