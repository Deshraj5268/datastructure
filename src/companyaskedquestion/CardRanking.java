package companyaskedquestion;

import java.util.HashMap;
import java.util.Map;

public class CardRanking {

    private static  String [] ranks = { "2","3","4","5","6","7","8","9","10",
            "J","Q","K","A"};
    public static void main(String[] args) {
        String[][] cardsArr = {
                {"9-H", "9-C", "9-D", "9-S"},
                {"2-S", "10-H", "9-C", "8-D"},
                {"K-H", "K-D", "K-C", "K-S"},
                {"2-H", "3-D", "7-C", "Q-S", "A-H"},
                {"5-H", "A-S", "K-D", "10-C", "J-H"}
        };

        for (String [] cards : cardsArr ) {
            System.out.println(highestCard(cards));
        }
    }

    public static String highestCard(String [] cards){
        Map<String, Integer> rankMap = new HashMap<>();

        for(int i=0;i<ranks.length;i++){
            rankMap.put(ranks[i], i);
        }

        Map<String,Integer> suitMap = new HashMap<>();
        suitMap.put("H", 0);
        suitMap.put("D", 1);
        suitMap.put("C", 2);
        suitMap.put("S", 3);

        String answer = cards[0];
        String [] best = answer.split("-");
        String [] curr;
        int bestRank, currRank;
        for(int i=1;i<cards.length;i++){
            curr = cards[i].split("-");
            currRank = rankMap.get(curr[0]);
            bestRank = rankMap.get(best[0]);
            if(currRank > bestRank || (currRank == bestRank && suitMap.get(curr[1]) > suitMap.get(best[1]))){
                answer = cards[i];
                best = curr;
            }
        }
        return answer;
    }
}
