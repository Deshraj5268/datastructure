package heap;

import javafx.util.Pair;

import java.util.*;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * */
public class TopKElement {

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 2, 2, 3, 3,3},
                {1, 2, 3},
                {1, 1, 2, 2, 3, 3}};
        int[] kArr = {2, 1, 2};
        for (int i = 0; i < mat.length; i++) {
            System.out.println("input : " + " :K: " + kArr[i] + " array " + Arrays.toString(mat[i]));
            int[] result = topKFrequent(mat[i], kArr[i]);
            System.out.println("result : " + Arrays.toString(result));
            result = topKElementUsingSorting(mat[i], kArr[i]);
            System.out.println("using sorting way : " + Arrays.toString(result));

           /* result = topKElementUsingTreeMap(mat[i], kArr[i]);
            System.out.println("using treeMap way : " + Arrays.toString(result));*/
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<Pair<Integer, Integer>>((x, y) -> x.getValue() - y.getValue());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Pair<Integer, Integer> currentPair;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            currentPair = new Pair<>(entry.getKey(), entry.getValue());
            if (minHeap.size() < k) {
                minHeap.add(currentPair);
            } else {
                if (minHeap.peek().getValue() < currentPair.getValue()) {
                    minHeap.poll();
                    minHeap.add(currentPair);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }

    public static int[] topKElementUsingSorting(int[] arr, int k) {
        // basic check
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int val : arr) {
            elementCountMap.put(val, elementCountMap.getOrDefault(val, 0) + 1);
        }

        List<Pair<Integer, Integer>> pairArrayList = new ArrayList<>(elementCountMap.size());
        for (Map.Entry<Integer, Integer> entrySet : elementCountMap.entrySet()) {
            pairArrayList.add(new Pair<>(entrySet.getKey(), entrySet.getValue()));
        }

        int[] result = pairArrayList.stream().sorted((p1, p2) -> p2.getValue() - p1.getValue())
                .limit(k).mapToInt(Pair::getKey).toArray();
        return result;
    }


   /* public static int [] topKElementUsingTreeMap(int [] arr, int k){
        TreeMap<KeyCount, Integer> treeMap = new TreeMap<>((k1,k2)->
        {
            int count = k2.count - k1.count;
            if (count == 0){
                return k1.key - k2.key;
            }
            return count;
        });
        for(int val : arr){
            treeMap.put(val, treeMap.getOrDefault(val,0)+1);
        }
        int [] result = new int[treeMap.size()];
        return result;
    }*/
}

class KeyCount{
    int key;
    int count;

    public KeyCount(int key, int count) {
        this.key = key;
        this.count = count;
    }
}
