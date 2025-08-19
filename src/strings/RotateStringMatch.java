package strings;

public class RotateStringMatch {

    public static void main(String[] args) {

        String [] src={"abcde","abcde"};
        String [] goal ={"cdeab","abced"};
        for(int i=0;i<src.length;i++) {
            System.out.print("RotateStringMatch possible for : "+src[i] + " <-> "+goal[i] + " :");
            System.out.println(rotateString(src[i], goal[i]));
        }
    }

    public static boolean rotateString(String s, String goal) {
        return (s.length() == goal.length() && (s+s).contains(goal));
    }
}
