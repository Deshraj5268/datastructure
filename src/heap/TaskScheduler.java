package heap;

import javafx.util.Pair;

import java.util.*;



/*problem
*
* https://leetcode.com/problems/task-scheduler/description/
* */
public class TaskScheduler {

    public static void main(String[] args) {

        int n =2;
        char [] tasks = {'A','A','A','B','B','B'};
        System.out.println("input : "+ Arrays.toString(tasks));
        int result = leastInterval(tasks,n);
        System.out.println("result : "+result);
    }

    public static int leastInterval(char[] tasks, int n) {
        int [] charCount = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for(int i=0;i<tasks.length;i++){
            charCount[tasks[i]-'A']++;
        }
        for(int i=0;i<charCount.length;i++){
            if(charCount[i]>0){
                pq.add(charCount[i]);
            }
        }
        int t=0;
        int val;
        while(!pq.isEmpty() || !queue.isEmpty()){
            t++;
            if(!pq.isEmpty()){
                val = pq.poll();
                val--;
                if(val>0){
                    queue.add(new Pair(val,t+n));
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() <= t){
                pq.add(queue.poll().getKey());
            }
        }
        return t;

    }
}
