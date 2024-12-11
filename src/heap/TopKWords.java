package heap;

import java.util.*;

public class TopKWords {


    public static void main(String[] args) {
        String [] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String > result = topKFrequent(words, k);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCountMap = new HashMap<>();
        List<String> result = new ArrayList();
        for(String word : words){
            wordCountMap.put(word,
                    wordCountMap.getOrDefault(wordCountMap,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        // Compare by length of the key first
                        int lengthComparison = Integer.compare(e1.getKey().length(), e2.getKey().length());
                        if (lengthComparison != 0) {
                            return lengthComparison;
                        } else {
                            // If lengths are equal, compare lexicographically
                            return e1.getKey().compareTo(e2.getKey());
                        }
                    }
                });

        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
            if(minHeap.size() < k){
                minHeap.add(entry);
            }else{
                if(minHeap.peek().getValue() < entry.getValue()){
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }

        while(!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }
        return result;

    }
}
