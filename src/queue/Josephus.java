package queue;

import java.util.LinkedList;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {

        int n = 5;
        int k = 2;
        System.out.println(josephusRec(n,k));
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=5;i++){
            list.add(i);
        }
        System.out.println(josephusListReduction(list,0,k-1));
    }

    public static int josephusRec(int n,int k){
        if(n == 1){
            return n;
        }
        // (size reduce by 1 + (k-1) shift required)% size +1 (new item target ele)
        return (josephusRec(n-1,k) + k-1) % n + 1;
    }

    public static int josephusListReduction(List<Integer> list,int start,int k){
        if(list.size() == 1){
            return list.get(0);
        }
        start = (start + k) % list.size();
        list.remove(start);
        return josephusListReduction(list,start,k);
    }
}
