package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class CerealBox {

    public static void main(String[] args) {


        int [][] nk = {/*{2,10},
                       {11,94},
                {2,10},*/
                {28,1}};
        int [][] mat = {/*{100, 15},
                {29,515, 119, 10, 327, 499, 787, 303, 373, 265, 411},
                {90,100},*/
                {240,1,269,33,176,271,224,356,146,186,347,348,204,144,309,148,321,270,171,358,208,17,114,49,253,61,46,31}
        };
        for(int i=0;i<nk.length;i++) {
            System.out.println(minSum(mat[i], nk[i][0], nk[i][1]));
        }
    }

    static long minSum(int a[], int n, int k){
        // code here
        long sum = 0;
        if(k < 10){
            k = 10;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // default is min heap
        Integer[] what = Arrays.stream( a ).boxed().toArray( Integer[]::new );
        pq.addAll(Arrays.asList(what));
       /* for(int val:a){
            pq.add(val);
        }*/
        int i=0;
        int maxValue=0;
        while(i<n && !pq.isEmpty()){
            maxValue = pq.remove();
            if(maxValue > k){
                pq.add(maxValue-k);
            }
            i++;
        }
        if(!pq.isEmpty()){
            Iterator<Integer> itr = pq.iterator();

            while(itr.hasNext()){
                sum += itr.next();
            }

        }
        return sum;

    }
}
