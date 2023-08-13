package heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
* problem : https://leetcode.com/problems/k-closest-points-to-origin/
* */
public class KClosestPointToK {

    static class DistanceAndPoint{
        double euclidean;
         Pair<Integer,Integer> point;

        public DistanceAndPoint(double euclidean, Pair<Integer, Integer> point) {
            this.euclidean = euclidean;
            this.point = point;
        }
    }

    public static void main(String[] args) {

        int [][][] mat = {{{2,2},{2,2},{2,2},{2,2},{2,2},{2,2},{1,1}},
                {{2,2},{3,5},{6,6},{1,1}},
                {{1,1},{2,2}}};
        int [] kArr = {1,3,1};
        for(int i=0;i<mat.length;i++){
            System.out.print("\nInput =-> k: "+kArr[i]+ " Array : ");
            Arrays.stream(mat[i]).forEach(x-> System.out.print(Arrays.toString(x)+","));
            int [][] result = kClosest(mat[i],kArr[i]);
            System.out.print("\nresult :");
           Arrays.stream(result).forEach(x-> System.out.print(Arrays.toString(x)+","));
        }
    }


    public int[][] kClosestOptimize(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(
                        (b[0] * b[0] + b[1] * b[1]),
                        (a[0] * a[0] + a[1] * a[1])
                )
        ); //only this is changed (swapped)
        for (int[] point : points) {
            maxHeap.add(point);
            //remove when size increase k
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = maxHeap.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }
    public static int[][] kClosest(int[][] points, int k){
        if(points == null || points.length <= k){
            return points;
        }
        PriorityQueue<DistanceAndPoint> maxHeap = new PriorityQueue<>(
                (x,y)-> {return y.euclidean<x.euclidean? -1:1; }
        );
        Pair<Integer,Integer> origin = new Pair<>(0,0);
        Pair<Integer,Integer> currentPair;
        DistanceAndPoint heapCustomData;
        for(int i=0;i<points.length;i++){
            currentPair = new Pair<>(points[i][0],points[i][1]);
            double euclideanDistance = calculateDistance(origin,currentPair);
            heapCustomData = new DistanceAndPoint(euclideanDistance,currentPair);
            if(i<k){
                maxHeap.add(heapCustomData);
            }else{
                if(maxHeap.peek().euclidean > heapCustomData.euclidean){
                    maxHeap.poll();
                    maxHeap.add(heapCustomData);
                }
            }
        }
        int heapSize = maxHeap.size();
        int [][] result = new int[heapSize][2];
        int index=0;
        while (index<heapSize){
            currentPair = maxHeap.poll().point;
            result[index][0] = currentPair.getKey();
            result[index][1] = currentPair.getValue();
            index++;
        }
        return result;
    }

    private static double calculateDistance(Pair<Integer, Integer> origin, Pair<Integer, Integer> currentPair) {
        int x = currentPair.getKey()- origin.getKey();
        int y = currentPair.getValue()- origin.getValue();
        return Math.sqrt(Math.abs((x*x)+(y*y)));
    }
}
