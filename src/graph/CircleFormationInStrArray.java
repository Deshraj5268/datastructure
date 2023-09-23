package graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* https://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
* */
public class CircleFormationInStrArray {


    static int totalChar = 26;

    public static void main(String[] args) {
        String [][] strArr = {{"geek", "king"},
                {"for", "geek", "rig", "kaf"},
                {"aab", "bac", "aaa", "cda"},
                {"aaa", "bbb", "baa", "aab"},
                {"aaa"},
                {"aaa", "bbb"},
                {"abc", "efg", "cde", "ghi", "ija"},
                {"ijk", "kji", "abc", "cba"}};
        boolean result;
        for(int i=0;i<strArr.length;i++){
            Arrays.stream(strArr[i]).forEach(x-> System.out.print(x+" "));
            System.out.println();
            result = isCircleFormationInStrArray(strArr[i]);
            System.out.println("result "+result);
        }
    }



    /*
    * calculate Indegree and outDegree of each vertex , which should be same and
    * check all node is connected or not
    * */
    public static boolean isCircleFormationInStrArray(String [] strArr){

        boolean [] mark = new boolean[totalChar];// fixed vertices
        int [] in = new int[totalChar];
        int [] out = new int[totalChar];
        List<List<Integer>> adj = new ArrayList<>(totalChar);
        for(int i=0;i<totalChar;i++){
            adj.add(new ArrayList<>());
        }

        calculateInDegreeAndOutDegreeAndAddEdges(adj,strArr,mark,in,out);

        // check indegree and out degree equality
        for(int i=0;i<totalChar;i++){
            if(in[i] != out[i]){
                return false;
            }
        }

        return isConnectedGraph(adj,mark,strArr[0].charAt(0)-'a');
    }

    private static boolean isConnectedGraph(List<List<Integer>> adj, boolean[] mark, int startV) {
        boolean [] visited = new boolean[totalChar];
        dfsUtil(adj,startV,visited);

        for (int i=0;i<totalChar;i++) {
            if(mark[i] && !visited[i]){
                return false;
            }
        }
        return true;
    }

    private static void dfsUtil(List<List<Integer>> adj, int startV, boolean[] visited){

        visited[startV] = true;
        for (int i=0;i<adj.get(startV).size();i++){
            if(!visited[adj.get(startV).get(i)]){
                dfsUtil(adj,adj.get(startV).get(i),visited);
            }
        }
    }
    private static void calculateInDegreeAndOutDegreeAndAddEdges(List<List<Integer>> adj, String[] strArr, boolean [] mark, int[] in, int[] out) {
        int first,last;
        for(int i=0;i<strArr.length;i++){
            first = strArr[i].charAt(0)-'a';
            last = strArr[i].charAt(strArr[i].length()-1)-'a';

            mark[first] = mark[last] = true;
            in[last]++;
            out[first]++;

            // add edges
            adj.get(first).add(last);
        }
    }
}
