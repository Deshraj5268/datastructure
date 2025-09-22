package advanceds.setcollection;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MySortedSet {

    static SortedSet<PlayerInfo> sortedSetPlayer;

    public static void main(String[] args) {

       // basicOps();

        List<PlayerInfo> playerInfoList = getCreatePlayer();
        sortedSetPlayer = new TreeSet<>((p1,p2)->{
            int score = Double.compare(p2.score, p1.score);
            if(score == 0){
                return p1.name.compareTo(p2.name);
            }
            return score;
        });
        sortedSetPlayer.addAll(playerInfoList);
        int k = 3;
        List<PlayerInfo> result = getTopKPlayerByScore(k);
        System.out.println(result);
        String name = "Alice";
        System.out.println("get User details of rank by name -"+ name +" : " +getRank(name));


    }

    public static List<PlayerInfo> getCreatePlayer() {
        return Arrays.asList(new PlayerInfo("Alice" , 1200),
                new PlayerInfo("Bob"   , 800),
                new PlayerInfo("Charlie" , 1500),
                new PlayerInfo("David" , 1000)
        );
    }


    private static List<PlayerInfo> getTopKPlayerByScore(int k) {
      return sortedSetPlayer.stream().limit(k).collect(Collectors.toList());
    }

    private static PlayerInfo getRank(String name){ // name exist
        for(PlayerInfo playerInfo : sortedSetPlayer){
            if(name.equalsIgnoreCase(playerInfo.name)){
                return playerInfo;
            }
        }
        return null;
    }

    private static void basicOps() {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(6);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(5);
        sortedSet.add(3); // ignore sorted ..
        //[2,3,4,5,6] -- finally

        System.out.println("print sorted set having duplicate element "+sortedSet); // maintain sorted order
        System.out.println("min element:"+sortedSet.first()); // min element [2]
        System.out.println("max element:"+sortedSet.last()); // last element [6]
        System.out.println("less than 4 element : "+sortedSet.headSet(4)); // less than the given  element [2,3]
        System.out.println("greater than or equal 0 element : "+sortedSet.tailSet(4)); // >= element [4,5,6] // inclusive 4
        System.out.println("subset 2 to 4 element : "+sortedSet.subSet(2,4)); //  [ 2,3] // first element is inclusive
    }
}

