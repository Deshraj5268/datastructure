package gfg.stack;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingElement {

    public static void main(String[] args) {
        String str = "zxvczbtxyzvy";
        char firstNonRepeatedElement = firstNonRepeatingElementUsingLinkedHashMap(str);
        if (firstNonRepeatedElement == '\0') {
            System.out.println("-1");
        } else {
            System.out.println(firstNonRepeatedElement);
        }
    }

    private static char firstNonRepeatingElementUsingLinkedHashMap(String str) {
        Map<Character, Integer> linkedHashMap = getOrderedElements(str);
        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() > -1) {
                return entry.getKey();
            }
        }
        return '\0';
    }

    public static Map<Character, Integer> getOrderedElements(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();
        int elementCount = 0;
        char element;
        Integer countValue;
        for (int i = 0; i < str.length(); i++) {
            element = str.charAt(i);
            countValue = map.get(element);
            if (countValue == null) {
                map.put(element, elementCount + 1);
            }else{
                countValue = Math.abs(countValue)+1;
                map.put(element, -countValue);
            }
        }
        return map;
    }

}