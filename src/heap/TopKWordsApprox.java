package heap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* misra algorithm
* https://abbybuilds.medium.com/misra-gries-algorithm-02d01bc6a3ec
*
*
* */
public class TopKWordsApprox {

    private int k;
    private Map<String , Integer> freqCountMap;

    public TopKWordsApprox(int k){
        this.k = k;
        this.freqCountMap = new HashMap<>();
    }
    public static void main(String[] args) {
        TopKWordsApprox topKWordsApprox = new TopKWordsApprox(6);
        String[] stream = {
                "apple","banana","cat","apple","dog","apple",
                "banana","banana","cat","dog","banana","ele"
        };

        for (String word : stream){
            topKWordsApprox.addWord(word);
        }

       for(Map.Entry<String, Integer> result : topKWordsApprox.topK()){
           System.out.println(result.getKey() + " " + result.getValue());
       }
    }


    /*
    *
    * approximate algorithm
    * idea is : reduce the count by 1 of more k words
    * remove word if count is zero
    *
    * Other approach we can use sliding window of size m , decrease count if size is full and store k element
    * */
    public void addWord(String word){

        if(freqCountMap.containsKey(word)){
            freqCountMap.put(word, freqCountMap.getOrDefault(word, 0)+1);
        }
        if(freqCountMap.size() < k){
            freqCountMap.put(word , 1);
        }else {

            // minimize space : decrement all count
            List<String> toRemove = new ArrayList<>();// concurrent modification is not possible in array
            for (Map.Entry<String, Integer> entry : freqCountMap.entrySet()) {
                Integer count = entry.getValue() - 1;
                String key = entry.getKey();
                if (count == 0) {
                    toRemove.add(key);
                } else {
                    freqCountMap.put(key, count);
                }
            }

            for (String zeroCountWord : toRemove) {
                freqCountMap.remove(zeroCountWord);
            }

            freqCountMap.put(word, 1);
        }
    }

    public List<Map.Entry<String, Integer>> topK() {
        return freqCountMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList());
    }
}
