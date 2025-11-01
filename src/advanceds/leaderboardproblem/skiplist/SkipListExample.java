package advanceds.leaderboardproblem.skiplist;

import advanceds.leaderboardproblem.setcollection.PlayerInfo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipListExample {

    /*
    * 1. ConcurrentSkipListMap<K,V>


   A sorted map backed by a skip list.
    Keys are kept in sorted order.
    Supports log(n) time complexity for search, insert, delete.
     Thread-safe (lock-free concurrency).

       Think of it as a TreeMap alternative, but implemented with a skip list.
    * */


    public static void main(String[] args) {
        List<PlayerInfo> playerInfoList =  Arrays.asList(new PlayerInfo("Alice" , 1200),
                new PlayerInfo("Bob"   , 800),
                new PlayerInfo("Charlie" , 1500),
                new PlayerInfo("David" , 1000)
        );

        ConcurrentSkipListSet<PlayerInfo> concurrentSkipListSet = new ConcurrentSkipListSet<>(
                Comparator.comparing(PlayerInfo::getScore, Comparator.reverseOrder()).thenComparing(PlayerInfo::getName));

        concurrentSkipListSet.addAll(playerInfoList);

        System.out.println("Leaderboard : "+concurrentSkipListSet.descendingSet());
        System.out.println("Top player : "+concurrentSkipListSet.first());
    }
}
