package strings.searchingalgos;

public class BasicSearching {

    public static void main(String[] args) {

        BasicSearching basicSearching = new BasicSearching();
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";

        basicSearching.bruteForceSearch(str,subString);
    }
    /*
    *
    * */
    public int bruteForceSearch(String text,String target){
        int j = 0;
        int textLength = text.length();
        int targetLength = target.length();
        for(int i=0;i<textLength-targetLength;i++){
            j = 0;
            while (j < targetLength && text.charAt(i+j) == target.charAt(j)){
                j++;
            }
            if(j == targetLength){
                return i;
            }
        }
        return -1;
    }

}
