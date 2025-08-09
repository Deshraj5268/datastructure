package gfg.stack;

import java.util.*;

public class FirstNonRepeatingElementInStream {

    public static void main(String[] args) {
        String str = "aabcabcd";
        String result = firstNonRepeatingElementInStreamUsingSet(str);
        System.out.println("input  :"+str);
        System.out.println("output :"+result);
         //aabcabcd
         //a#bbbc#d
        /*
        * Scanner kb = new Scanner(System.in);
        int t=kb.nextInt();
        while(t-->0) {
            int n = kb.nextInt();
            char [] arr = new char[n];
            for(int i=0;i<arr.length;i++){
                arr[i] = (char)kb.next().charAt(0);
               // System.out.println(arr[i]);
            }
            //String str = kb.next();
            //System.out.println(new String(arr));
            firstRepeatingElementInStream(new String(arr));
            System.out.println();
        }*/

    }

    public static String firstNonRepeatingElementInStream(String str){
        Queue<Character> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        Integer value;
        char element;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
            element = str.charAt(i);
            value = map.get(element);
            if(value == null){
                map.put(element,count+1);
                queue.offer(element);
            }else {
                value = Math.abs(value)+1;
                map.put(element,-value);
                deleteFrontElementIfCountNegative(queue,map);
            }
            if(queue.isEmpty()){
                result.append("#");
            }else {
                result.append(queue.peek());
            }
        }
        return result.toString();
    }

    public static String firstNonRepeatingElementInStreamUsingSet(String str){
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        char element;
        Integer mapVal;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
             element = str.charAt(i);
            mapVal = map.get(element);
            if(mapVal == null){
                map.put(element , 1);
                queue.add(element);
            }else{
                map.put(element, mapVal+1);
                while (!queue.isEmpty() && map.get(queue.peek()) > 1 ){
                    queue.poll();
                }
            }
            if(queue.isEmpty()){
                result.append("#");
            }else {
                result.append(queue.peek());
            }
        }
        return result.toString();
    }

    public static void deleteFrontElementIfCountNegative(Queue<Character> queue, Map<Character,Integer> map){
        while (!queue.isEmpty() && map.get(queue.peek()) < 0){
            queue.poll();
        }
    }
}
