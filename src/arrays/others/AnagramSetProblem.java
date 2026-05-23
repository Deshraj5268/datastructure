package arrays.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class AnagramSetProblem {

    public static Set<Set<String>> groupAnagram(List<String> words){
        HashMap<String,HashSet<String>> resultMap = new HashMap<>();
        Set<Set<String>> resultSet = new HashSet<>();
        Iterator it = words.iterator();
        String originalKey = null;
        String key = null;
        while (it.hasNext()){
            key = (String)it.next();
            originalKey = key;
            char [] arr = key.toCharArray();
            Arrays.sort(arr);
            key = new String(arr);

            HashSet<String> originalSet = resultMap.get(key);
            if(originalSet == null){
                originalSet = new HashSet<>();
                resultMap.put(key,originalSet);
            }
            resultMap.get(key).add(originalKey);
        }
        for(Map.Entry<String,HashSet<String>> res:resultMap.entrySet()){
            resultSet.add(res.getValue());
        }
        return resultSet;
    }

    public static void main(String[] args) {

        List<String> words = new LinkedList<>();


        words.add("cat");
        words.add("dog");
        words.add("god");
        Set<Set<String>> result = groupAnagram(words);

        System.out.println(result.toString());

    }
}
