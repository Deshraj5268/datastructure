package graph.disjointset;

import java.util.Arrays;


/*https://www.youtube.com/watch?v=wU6udHRIkcc*/

public class DisJointSetDriver {

    private static int[] parent;
    private static  UDGraph udGraph;

    public static void main(String[] args) {
        int totalV = 8;
        int edge = 9;
        createGraph(totalV,edge);

        makeDisjointSet(totalV,edge);
        printDisjointSet(parent);

        /*makeDisjointWeightedSet(totalV,edge);
        printDisjointSet(parent);

        Arrays.fill(parent,-1);// reinitialize for path com
        makeDisjointPathCmp(totalV,edge);
        System.out.println("path comp");
        printDisjointSet(parent);*/
    }

    private static void makeDisjointSet(int totalV, int edge) {
        int x;
        int y;
        //iterate all edges
        for (int i = 0; i < udGraph.e; i++) {
            x = DisJointOps.findSet(parent, udGraph.edge[i].src);
            y = DisJointOps.findSet(parent, udGraph.edge[i].dest);
            if (x == y) {
                System.out.println("cycle exist between "+udGraph.edge[i].src + " and "+udGraph.edge[i].dest);
            } else {
                DisJointOps.unionSet(parent, x, y);
            }
        }
    }

    private static void printDisjointSet(int[] parent) {
        System.out.println(Arrays.toString(parent));
    }

    private static void makeDisjointWeightedSet(int totalV, int edge) {
        int x;
        int y;
        //iterate all edges
        for (int i = 0; i < udGraph.e; i++) {
            x = DisJointOps.findWeightedSet(parent, udGraph.edge[i].src);
            y = DisJointOps.findWeightedSet(parent, udGraph.edge[i].dest);
            if (x == y) {
                //return true;
                System.out.println("cycle exist between "+udGraph.edge[i].src + " and "+udGraph.edge[i].dest);
            } else {
                DisJointOps.unionWeightedSet(parent, x, y);
            }
        }
    }

    private static void makeDisjointPathCmp(int totalV, int edge) {
        int x;
        int y;
        //iterate all edges
        for (int i = 0; i < udGraph.e; i++) {
            x = DisJointOps.findPathSet(parent, udGraph.edge[i].src);
            y = DisJointOps.findPathSet(parent, udGraph.edge[i].dest);
            if (x == y) {
                //return true;
                System.out.println("cycle exist between "+udGraph.edge[i].src + " and "+udGraph.edge[i].dest);
            } else {
                DisJointOps.unionPathSet(parent, x, y);
            }
        }
    }


    private static void createGraph(int totalV, int edge) {
        parent = new int[totalV];
        udGraph = new UDGraph(totalV, edge);
        /*
        *          6
        *      0 -------2
        *      |        |
        *    0 |        | 1
        *      |        |
        *      1 -------3
        *      |    4
        *    5 |
        *      |    8
        *      4 -------6
        *      |        |
        *    2 |        | 3
        *      |        |
        *      5 -------7
        *           7
        *
        *
        *
        * */
        udGraph.edge[0].src = 0;
        udGraph.edge[0].dest = 1;

        udGraph.edge[1].src = 2;
        udGraph.edge[1].dest = 3;

        udGraph.edge[2].src = 4;
        udGraph.edge[2].dest = 5;

        udGraph.edge[3].src = 6;
        udGraph.edge[3].dest = 7;

        udGraph.edge[4].src = 1;
        udGraph.edge[4].dest = 3;

        udGraph.edge[5].src = 1;
        udGraph.edge[5].dest = 4;

        udGraph.edge[6].src = 0;
        udGraph.edge[6].dest = 2;

        udGraph.edge[7].src = 5;
        udGraph.edge[7].dest = 7;

        udGraph.edge[8].src = 4;
        udGraph.edge[8].dest = 6;

        Arrays.fill(parent, -1); //initialize with -1
    }
}
