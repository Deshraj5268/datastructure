package backtracking;


public class Utility {

    private Utility(){

    }

    public static void swap(StringBuilder sb , int src , int dst){
        char temp = sb.charAt(src);
        sb.setCharAt(src, sb.charAt(dst));
        sb.setCharAt(dst, temp);
    }
}
