package heap;

import java.util.*;

public class PriorityQueueJava {



    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>(); // by default is min heap

        for(int i=10;i>0;i--){
            pq.offer(i);
        }
        for(int i=0;i<10;i++){
            System.out.print(pq.poll() +" ");
        }

        System.out.println("\n collections inserted into PQ");
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(12);
        arrayList.add(24);
        arrayList.add(25);

        Queue<Integer> pq1 = new PriorityQueue(arrayList);
        for(int i=0;i<arrayList.size();i++){
            System.out.print(pq1.remove()+ " ");
        }

        /*CustomHeapData c1 = new CustomHeapData(0,1);
        CustomHeapData c2 = new CustomHeapData(5,11);
        CustomHeapData c3 = new CustomHeapData(2,0);
        CustomHeapData c4 = new CustomHeapData(1,3);

        Queue<CustomHeapData> cPQ = new PriorityQueue<>((x,y)->{x>y ?0:-1;);*/


    }


}