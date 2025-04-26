package heap;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Consumer;


/*problem
 *
 * https://leetcode.com/problems/task-scheduler/description/
 * */
public class TaskScheduler {

    public static void main(String[] args) {

        int n =2;
        char [][] tasks = {
                /*{'A', 'A', 'A', 'B', 'B', 'B'},
                {'A', 'C', 'A', 'B', 'D', 'B'},*/
                {'A', 'A', 'A', 'B'},
                {'A', 'A', 'B'}
        };
        int [] interval = {/*2, 1,*/ 2,1};
        for(int i=0;i<tasks.length;i++) {
            System.out.println("input : " + Arrays.toString(tasks[i]) + " interval : " + interval[i]);
            int result = leastInterval(tasks[i], interval[i]);
            System.out.println("result : " + result);
            int result1 = leastIntervalExetended(tasks[i], interval[i]);
            System.out.println("result with print task flow : " + result1);

            int result2 = leastIntervalBuilderPattern(tasks[i], interval[i]);
            System.out.println("result : " + result2);
        }
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

    public static int leastIntervalExetended(char[] tasks, int n) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((p1, p2)->p2.getValue() - p1.getValue());
        Queue<Pair<Integer,Pair<Character,Integer>>> queue = new LinkedList<>();
        for (char task : tasks) {
            charCountMap.put(task, charCountMap.getOrDefault(task,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        int time=0;
        int val;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Pair<Character, Integer> charCountPair = pq.poll();
                val = charCountPair.getValue();
                System.out.print(charCountPair.getKey() + " -> "+val +" at time :"+time+ " , ");
                val--;
                if(val>0){
                    queue.add(new Pair<>(time+n, new Pair(charCountPair.getKey(), val)));
                }
            }
            // printing purpose
            else {
                System.out.println("idle at time : "+time);
            }
            if(!queue.isEmpty() && queue.peek().getKey() <= time){
                //  System.out.println("procced data from queue..  "+queue.peek().getValue().getKey() + " -> "+queue.peek().getValue().getValue() +" time : "+queue.peek().getKey());
                pq.add(queue.poll().getValue());
            }
        }
        System.out.println();
        return time;

    }


    public static int leastIntervalBuilderPattern(char[] tasks, int n) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        PriorityQueue<TaskData> pq = new PriorityQueue<>((p1, p2)->p2.getCount() - p1.getCount());
        Queue<TaskData> queue = new LinkedList<>();
        for (char task : tasks) {
            charCountMap.put(task, charCountMap.getOrDefault(task,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
                pq.add(new TaskData.TaskDataBuilder().withData(
                    data -> {data.task = entry.getKey();
                        data.count = entry.getValue();
                    }).build()
            );
        }

        GlobalTimeCounter globalTimeCounter = new GlobalTimeCounter();
        globalTimeCounter.time = 0;
        int val;
        while(!pq.isEmpty() || !queue.isEmpty()){
            globalTimeCounter.time++;
            if(!pq.isEmpty()){
                TaskData charCountPair = pq.poll();
                if(charCountPair.getCount()-1>0){
                    queue.add(new TaskData.TaskDataBuilder().withData(
                            taskDataBuilder -> {
                                taskDataBuilder.count = charCountPair.getCount()-1;
                                taskDataBuilder.task = charCountPair.getTask();
                                taskDataBuilder.time = globalTimeCounter.time+n;
                            }
                    ).build() );
                }
            }
            if(!queue.isEmpty() && queue.peek().getTime() <= globalTimeCounter.time){
                pq.add(queue.poll());
            }
        }
        return globalTimeCounter.time;
    }
}

class GlobalTimeCounter {
    int time;
}
class TaskData{
    private char task;
    private int count;
    private int time;


    public char getTask() {
        return task;
    }

    public int getCount() {
        return count;
    }

    public int getTime() {
        return time;
    }

    public TaskData(TaskDataBuilder taskDataBuilder){
        this.task = taskDataBuilder.task;
        this.count = taskDataBuilder.count;
        this.time = taskDataBuilder.time;
    }

    static class TaskDataBuilder{
        char task;
        int count;
        int time;

        public TaskDataBuilder withData(Consumer<TaskDataBuilder> consumer){
            consumer.accept(this);
            return this;
        }

        public TaskData build(){
            return new TaskData(this);
        }
    }
}
