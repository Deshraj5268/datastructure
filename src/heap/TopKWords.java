package heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKWords {


    public static void main(String[] args) {
        String [][] words = {
                {"i","love","leetcode","i","love","coding"},
                {"the","day","is","sunny","the","the","the","sunny","is","is"}
        };
        int [] k = {2, 4};
        for(int i=0;i<words.length;i++) {
            List<String> result = topKFrequent(words[i], k[i]);
            List<String> result1 = topKFrequentOptimize(words[i], k[i]);
            System.out.println(Arrays.toString(result.toArray()));
            System.out.println(Arrays.toString(result1.toArray()));
        }
    }
    public static List<String> topKFrequent(String[] words, int k){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Convert the map to a list and sort it
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((entry1, entry2) -> {
            int freqComparison = Integer.compare(entry2.getValue(), entry1.getValue());
            if (freqComparison != 0) {
                return freqComparison; // Sort by frequency in descending order
            } else {
                return entry1.getKey().compareTo(entry2.getKey()); // Sort by key in lexicographical order
            }
        });

        // Step 3: Extract the top k entries
        return entryList.stream()
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topKFrequentOptimize(String[] words, int k) {
        Map<String,Integer> wordCountMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String word : words){
            wordCountMap.put(word,
                    wordCountMap.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap =
                new PriorityQueue<>((entry1, entry2) -> {
                    int freqComparison = Integer.compare(entry1.getValue(), entry2.getValue());
                    if (freqComparison != 0) {
                        return freqComparison; // Sort by frequency in descending order
                    }
                    return entry1.getKey().compareTo(entry2.getKey()); // Sort by key in lexicographical order
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
         //Collections.reverse(result);
        return result;

    }
}
