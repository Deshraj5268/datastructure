package arrays.others;

public class FindExelColumnForNumber {

    public static String findColomnForNumber(int n){
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        while (n > 0){
            reminder = n%26;
            if(reminder == 0){
                sb.append('Z');
                n = (n/26) - 1;
            }else {
                sb.append((char)(reminder-1 + 'A'));
                n = (n/26);
            }
        }
        return sb.reverse().toString();
    }

    /*
    * n*logn ( log for pow function)
    *
    * */
    public static int findStrToNumber(String str){
        if(str == null){
            return 0;
        }
        int result = 0;
        int n = str.length()-1;
        for(int i=n;i>=0;i--){
            result += Math.pow(26,(n-i))*(str.charAt(i)-'A'+1);
        }
        return result;
    }


    /*
    * CDA,
3*26*26 + 4*26 + 1   = pow function

*   ((26*0+3)*26+4)*26+1
    *
    * */
    public static int findStrToNumberOptimize(String str){
        if(str == null){
            return 0;
        }
        int result = 0;
        int n = str.length()-1;
        for(int i=0;i<=n;i++){
            result =  result*26 + (str.charAt(i)-'A'+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 52;
        String str;
        for(int i= 25;i<50;i++) {
            str = findColomnForNumber(i);
            System.out.print((i)+str + " :");
            System.out.println(findStrToNumber(str));

            System.out.println("optimize "+findStrToNumberOptimize(str));
        }
        /*System.out.println();
        String str = "A";
        System.out.print(findStrToNumber(str)+" ");*/
    }
}