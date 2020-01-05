package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class CardProb_950 {


    /*
    * sort array in increasing order
    * traverse from the last
    * delete last element and add at first
    * pic next element and add it first
    * */
    public static int [] deckRevealedIncreasing(int [] arr){
        if(arr == null || arr.length == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(arr);
        int [] resultArr = new int[arr.length];
        deque.add(arr[arr.length-1]);
        int temp;
        for(int i = arr.length-2;i>=0;i--){
            temp = deque.removeLast();
            deque.addFirst(temp);
            deque.addFirst(arr[i]);
        }
        Iterator<Integer> it = deque.iterator();
        int k = 0;
        while (it.hasNext()){
            resultArr[k++] = it.next();
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int [] arr = {17,13,11,2,3,5,7};
        int [] result = deckRevealedIncreasing(arr);
        System.out.println(Arrays.toString(result));

    }
}
