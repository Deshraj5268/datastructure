package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RecognizeString {

    public static void main(String[] args) {
        String result = reorganizeString("aab");
        System.out.println("result" + result);
    }
    public static String reorganizeString(String s) {
        Map<Character,Integer> freqCount = new HashMap<>();
        for(char ch:s.toCharArray()){
            freqCount.put(ch,freqCount.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new
                PriorityQueue<>((item1,item2)->(item2.getValue()-item1.getValue()));

        maxHeap.addAll(freqCount.entrySet());

        Map.Entry<Character,Integer> prev = null;
        Map.Entry<Character,Integer> currentEntry;
        StringBuilder output = new StringBuilder();
        int count = 0;
        while(!maxHeap.isEmpty() || prev != null){

            if(maxHeap.isEmpty() && prev != null){
                return "";
            }

            currentEntry = maxHeap.poll();
            output.append(currentEntry.getKey());
            count = currentEntry.getValue()-1;

            if(prev != null){
                maxHeap.add(prev);
                prev = null;
            }

            if(count != 0){
             //   prev = Map.enty(currentEntry.getKey(), count);
            }
        }
        return output.toString();
    }
}
