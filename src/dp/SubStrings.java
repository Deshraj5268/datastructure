package dp;

public class SubStrings {

    public static void main(String[] args) {
        String str = "abcd";
        generateAllSubStringLengthWise(str);
        System.out.println("printAllSubstring ");
        printAllSubstring(str);
    }

    /*
    * O(n^3)
    *
    * Count of non-empty substrings is n*(n+1)/2
       If we include empty string also as substring, the count becomes n*(n+1)/2 + 1
    * */
    public static void generateAllSubStringLengthWise(String str){
        int n = str.length();
        for(int i=1;i<=n;i++){
            System.out.println("length : "+i);
            for(int j=0;j<=n-i;j++){ //n-i+1 substring possible
                /*for(int k=j;k<i+j;k++){
                    System.out.print(str.charAt(k));
                }*/
                System.out.println(str.substring(j , i+j));
               // System.out.println();
            }

        }
    }

    public static void printAllSubstring(String str){
       if(str == null){
           return;
       }
        String subString;
        int n = str.length();
        for(int i=0;i < n;i++){
            for(int j=i+1;j<=n;j++){
                subString = str.substring(i,j);// i inclusive and j is exclusive
                System.out.println("length :"+(j-i)+ " "+subString);
            }
            System.out.println();
        }
    }
}
