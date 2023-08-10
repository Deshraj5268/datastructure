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

    /*
    * calculate count of each task
    * store into maxheap
    * initialize start time =0
    * pull the data from heap decrease the task count
    * store this data to queue with addition to ideal time (n+current time)
    * pull the data from queue if the queue not empty and  current time>= Peek data
    * */
    public static int leastInterval(char[] tasks, int n) {
        int [] charCount = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (char task : tasks) {
            charCount[task - 'A']++;
        }
        for (int j : charCount) {
            if (j > 0) {
                pq.add(j);
            }
        }
        int time=0;
        int val;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                val = pq.poll();
                val--;
                if(val>0){
                    queue.add(new Pair(val,time+n));
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() <= time){
                pq.add(queue.poll().getKey());
            }
        }
        return time;

    }
}
