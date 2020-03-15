package graph.disjointset;

import java.util.Arrays;

public class CycleInUnDGraph {

    public static boolean isCycle(UDGraph udGraph) {
        int[] parent = new int[udGraph.v];
        Arrays.fill(parent, -1); //initialize with -1
        int x;
        int y;
        //iterate all edges
        for (int i = 0; i < udGraph.e; i++) {
            x = DisJointOps.findSet(parent, udGraph.edge[i].src);
            y = DisJointOps.findSet(parent, udGraph.edge[i].dest);
            if (x == y) {
                return true;
            }
            DisJointOps.unionSet(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 3;
        int e = 3;
        UDGraph udGraph = new UDGraph(v, e);
        udGraph.edge[0].src = 0;
        udGraph.edge[0].dest = 1;

        // add edge 1-2
        udGraph.edge[1].src = 1;
        udGraph.edge[1].dest = 2;

        // add edge 0-2
        udGraph.edge[2].src = 0;
        udGraph.edge[2].dest = 2;

        if (isCycle(udGraph))
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }

}
