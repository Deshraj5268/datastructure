package heap;

import java.util.*;

import javafx.util.Pair;

/*
* https://leetcode.com/problems/reorganize-string/description/
* */
public class RecognizeString {

    public static void main(String[] args) {
        String [] input = {"aab", "abab"};
        for(int i=0;i<input.length;i++) {
            String result = reorganizeString(input[i]);
            System.out.println("result" + result);
            String result1 = recognizeStringUsingTaskSchedulerWay(input[i]);
            System.out.println("result using taskSchedule : "+result1);
        }
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
                //  prev = Map.Entry(currentEntry.getKey(), count);
            }
        }
        return output.toString();
    }


    public static String recognizeStringUsingTaskSchedulerWay(String s) {
        return leastIntervalExtended(s.toCharArray(), 1);
    }

    public static String leastIntervalExtended(char[] tasks, int n) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> charCountMap = new HashMap<>();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2)->p2.getValue() - p1.getValue());
        Queue<Pair<Integer, Pair<Character, Integer>>> queue = new LinkedList<>();
        for (char task : tasks) {
            charCountMap.put(task, charCountMap.getOrDefault(task,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        int time=0;
        int val;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Pair<Character, Integer> charCountPair = pq.poll();
                val = charCountPair.getValue();
                val--;
                result.append(charCountPair.getKey());
                if(val>0){
                    queue.add(new Pair<>(time+n, new Pair(charCountPair.getKey(), val)));
                }
            } else {
                return "";
            }
            if(!queue.isEmpty() && queue.peek().getKey() <= time){
                pq.add(queue.poll().getValue());
            }
        }
        return result.toString();
    }
}
