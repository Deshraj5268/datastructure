package strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class WordCount {


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello world");
        arrayList.add("deshraj singh");
        arrayList.add("chandraj singh");
        arrayList.add("world is so beautiful");
        //TreeMap<String,Integer> result = wordCount(arrayList);
    }

    /*private static TreeMap<String,Integer> wordCount(ArrayList<String> arrayList) {
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
        TreeMap<String ,Integer> treeMap = new TreeMap<>(hashMap,(x,y) ->{ return hashMap.get(x) > hashMap.get(y) ?})
    }*/
}
