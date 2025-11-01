package advanceds.leaderboardproblem.setcollection;

public class PlayerInfo {

    String name;
    double score;

    public PlayerInfo(String name, double count) {
        this.name = name;
        this.score = count;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
