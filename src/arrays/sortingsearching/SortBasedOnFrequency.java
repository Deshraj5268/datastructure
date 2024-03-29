package src.arrays.sortingsearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
            sortByFrequencyWay1(arr[i]);
            System.out.println("output :" + Arrays.toString(arr[i]));
        }
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
