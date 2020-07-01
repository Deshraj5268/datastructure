package dp;

public class SubStrings {

    public static void main(String[] args) {
        String str = "abc";
        generateAllSubString(str);
    }

    /*
    * O(n^3)
    * */
    public static void generateAllSubString(String str){
        int n = str.length();
        for(int i=1;i<=n;i++){
            System.out.println("length : "+i);
            for(int j=0;j<=n-i;j++){ //n-i+1 substring possible
                for(int k=j;k<i+j;k++){
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }

        }
    }
}
