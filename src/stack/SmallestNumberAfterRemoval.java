package stack;

import java.util.Deque;
import java.util.LinkedList;

public class SmallestNumberAfterRemoval {

    public static void main(String[] args) {
        String [] strArr = {"1542219", "100", "50800"};
        int [] xArr = {3, 3, 1};
        for (int i=0;i<strArr.length;i++){
            System.out.println("smallest number for "+strArr[i]+ " : "+removeKDigits(strArr[i], xArr[i]));
        }
    }

    public static String removeKDigits(String number, int x) {
        int n = number.length();
        if(n < x){
            return "";
        }

        Deque<Integer> deque = new LinkedList<>();
        int current;
        for(int i=0;i<n;i++){
            current = number.charAt(i)-'0';
            while (x > 0 && !deque.isEmpty() && deque.peekLast() > current){ // remove if deque peek is greater than current element
                deque.removeLast();
                x--;
            }
            deque.addLast(current);
        }
        while( x > 0 && !deque.isEmpty()){ // increasing order 123456 , x = 2
            x--;
            deque.pop();
        }

        // remove leading 0,  0800 , x =1
        int idx = 0;
        while (!deque.isEmpty() && deque.peekFirst() == 0){
            deque.removeFirst();
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        String result = sb.length() == 0 ? "": sb.toString();

        return idx == result.length() ? "0" : result;
    }
}
