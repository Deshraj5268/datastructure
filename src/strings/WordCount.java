package strings;

import java.util.*;

public class WordCount {


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello world");
        arrayList.add("deshraj singh");
        arrayList.add("chandraj singh");
        arrayList.add("world is so beautiful");
        Map<String,Integer> result = wordCount(arrayList);
        for(Map.Entry<String,Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + " : "+entry.getValue());
        }
    }

    private static Map<String,Integer> wordCount(ArrayList<String> arrayList) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String line:arrayList){
            String [] tempArr = line.split(" ");
            for(String str:tempArr){
                if(hashMap.get(str) ==  null){
                    hashMap.put(str,1);
                }else {
                    hashMap.put(str,hashMap.get(str)+1);
                }
            }
        }
        SortedMap<String,Integer> map = new TreeMap<>();
        map.putAll(hashMap);
        return map;
    }
}
