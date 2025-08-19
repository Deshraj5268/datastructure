package arrays.sortingsearching;

import javafx.util.Pair;

import java.util.*;

public class SortBasedOnFrequency {

    static class FrequencyIndex{
        int frequency;
        int indexOrValue;

        public FrequencyIndex(){

        }
    }
    public static void main(String[] args) {
        Integer[][] arr
                = {{ 2, 5, 2, 6, -1, 99, 5, 8, 8, 8 },
                {5, 5, 4, 6, 4}};
        for(int i=0;i<arr.length;i++) {
            System.out.println("input :" + Arrays.toString(arr[i]));
           /* sortByFrequencyWay1(arr[i]);
            System.out.println("output :" + Arrays.toString(arr[i]));*/
            sortByFrequencyUsingLinkedHashMap(arr[i]);
            System.out.println("output :" + Arrays.toString(arr[i]));
        }
    }

    public static void sortByFrequencyUsingLinkedHashMap(Integer [] inputArr){
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for(Integer val : inputArr){
            linkedHashMap.put(val, linkedHashMap.getOrDefault(val,0) + 1);
        }

        Integer [][] freqArr = new Integer[linkedHashMap.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> entrySet : linkedHashMap.entrySet()){
            freqArr[i][0] = entrySet.getKey();
            freqArr[i][1] = entrySet.getValue();
            i++;
        }
        Arrays.sort(freqArr, (f1, f2)->f2[1] - f1[1]);
        int f=0;
        for(int j=0;j<freqArr.length;j++) {
            for (int k = 0; k < freqArr[j][1]; k++) {
                inputArr[f++] = freqArr[j][0];
            }
        }
    }

    public  static List<Character> frequencySort(String s){
        Map<Character, Integer> charFreqCount = new HashMap<>();
        //StringBuilder result = new StringBuilder();
        List<Character> result = new ArrayList<>();
        char ch;
        for(int k=0;k<s.length();k++){
            ch = s.charAt(k);
            charFreqCount.put(ch, charFreqCount.getOrDefault(ch, 0)+1);
        }

        List<Pair<Character, Integer>> charFreqCountList = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : charFreqCount.entrySet()) {
            charFreqCountList.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        /*Collections.sort(charFreqCountList, (p1, p2)->{
            int freqCount = p2.getValue() - p1.getValue();
            if(freqCount != 0){
                return freqCount;
            }
            return p2.getKey().compareTo(p1.getKey());
        }); */ // descending order by natural order
        //charFreqCountList.sort((p1,p2)->p2.getValue() - p1.getValue() == 0 ? p2.getKey().compareTo(p1.getKey()) :1);

        charFreqCountList.sort((p1,p2)->p2.getValue() - p1.getValue());
        int countChar;
        char charVal;
        for(int i=0;i<charFreqCountList.size();i++){
            countChar = charFreqCountList.get(i).getValue();
            charVal = charFreqCountList.get(i).getKey();
            for(int j=0;j<countChar;j++){
                result.add(charVal);
            }
        }
        return result;

        // Your code goes here

    }

    public static void sortByFrequencyWay1(Integer [] inputArr){
        if(inputArr == null || inputArr.length == 0){
            return ;
        }
        Map<Integer,FrequencyIndex> map = prepareHashMapByFrequency(inputArr);
        Arrays.sort(inputArr,
                (element1,element2)->{
                    FrequencyIndex f1 = map.get(element1);
                    FrequencyIndex f2 = map.get(element2);
                  if(f1.frequency != f2.frequency){
                      return f2.frequency-f1.frequency;
                  }else{
                      return f1.indexOrValue -f2.indexOrValue;
                  }

                });
    }

    private static Map<Integer,FrequencyIndex> prepareHashMapByFrequency(Integer [] inputArr){
        Map<Integer,FrequencyIndex> map = new HashMap<>();
        FrequencyIndex frequencyIndex;
        for(int i=0;i<inputArr.length;i++){
            frequencyIndex = map.get(inputArr[i]);
            if(frequencyIndex != null){
                frequencyIndex.frequency++;
            }else{
                frequencyIndex = new FrequencyIndex();
                frequencyIndex.indexOrValue = i;
                frequencyIndex.frequency = 1;
            }
            map.put(inputArr[i],frequencyIndex);
        }
        return map;
    }

 /*   public static void sortByFrequencyUsingQuickSort(Integer [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        FrequencyIndex [] frequencyIndicesArr = new FrequencyIndex[arr.length];
        for(int i=0;i<frequencyIndicesArr.length;i++){
            frequencyIndicesArr[i].indexOrValue = arr[i];
            frequencyIndicesArr[i].frequency = 0;
        }

    }

    public static void customQuickSort()*/

}
