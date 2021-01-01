package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class PrintPathSrcToDst {
    private static LinkedList<Integer>[] adj;
    private  static boolean [] visited;

    public static void main(String[] args) {
        int totalVertex = 4;
        AdjacencyMatrix adjObj =  new AdjacencyMatrix(totalVertex);
        adj = adjObj.getAdj();

        adjObj.addEdge(0, 1);
        adjObj.addEdge(0, 3);
        adjObj.addEdge(0, 2);
        adjObj.addEdge(1, 3);
        adjObj.addEdge(2, 0);
        adjObj.addEdge(2, 1);
        int srcV = 2;
        int dstV = 3;
        printAllPaths(srcV,dstV,totalVertex);
    }

    private static void printAllPaths(int srcV, int dstV, int totalVertex) {
        int [] pathArr = new int[totalVertex];
        int pathLength = 0;
        visited = new boolean[totalVertex];
        printAllPathUtil(srcV,dstV,pathArr,pathLength);
    }

    /*
    * taking boolean visited and  pathArr for storing element
    * start traversing the adjList
    * pathArr[pathLenth]=src;
    * mark visited = true;
    * if src == dest then print path
    *    mark visited =false
    * else
    *   for given src do recursively
    *
    *  pathLength--;
    *  mark visited = false
    * */
    private static void printAllPathUtil(int srcV, int dstV, int[] pathArr, int pathLength) {
        pathArr[pathLength] = srcV;
        pathLength++;
        visited[srcV] = true;
        if(srcV == dstV){
            printPathElements(pathArr,pathLength);
            System.out.println();
            visited[srcV] = false;
            return;
        }
        Iterator<Integer> itr = adj[srcV].iterator();
        int tempV = 0;
        while (itr.hasNext()){
            tempV = itr.next();
            if(!visited[tempV]){
                printAllPathUtil(tempV,dstV,pathArr,pathLength);
            }
        }
        pathLength--;
        visited[srcV] = false;
    }

    private static void printPathElements(int[] pathArr, int pathLength) {
        if(pathLength == 0){
            return;
        }
        printPathElements(pathArr,pathLength-1);
        System.out.print(pathArr[pathLength-1]+" ");
    }
}
