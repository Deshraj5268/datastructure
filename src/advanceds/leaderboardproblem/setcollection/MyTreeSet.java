package advanceds.leaderboardproblem.setcollection;

import java.util.TreeSet;

public class MyTreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(9);
        treeSet.add(6);
        treeSet.add(5);

        System.out.println(treeSet);
        System.out.println(treeSet.lower(7)); //6
        System.out.println(treeSet.higher(7));//9
        System.out.println(treeSet.descendingSet()); // decreasing order
        System.out.println(treeSet.contains(6)); //t/f
    }
}
