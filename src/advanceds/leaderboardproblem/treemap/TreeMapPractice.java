package advanceds.leaderboardproblem.treemap;

import java.util.TreeMap;

public class TreeMapPractice {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        TreeMap<Integer, Integer> treeMap  = new TreeMap<>();
        treeMap.put(1,3);
        treeMap.put(2,5);
        treeMap.put(4,7);
        treeMap.put(6,5);

        System.out.println(treeMap.ceilingKey(3));
        System.out.println(treeMap.descendingMap());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap.containsKey(2));
        System.out.println(treeMap.subMap(1,4));
        System.out.println(treeMap.containsValue(7));

        /*
        * 4
          {6=5, 4=7, 2=5, 1=3}
            1=3
            6=5
            true
            {1=3, 2=5}
        * */
    }
}


