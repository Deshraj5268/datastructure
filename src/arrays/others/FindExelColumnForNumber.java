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

    public static int findStrToNumber(String str){
        int result = 0;
        int n = str.length()-1;
        for(int i=0;i<=n;i++){
            result = result + ((int)(str.charAt(n-i)-'A'+1)*(int)Math.pow(26,i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 52;
        String str = new String();
        for(int i= 25;i<50;i++) {
            str = findColomnForNumber(i);
            System.out.print((i)+str + " :");
            System.out.println(findStrToNumber(str));
        }
        /*System.out.println();
        String str = "A";
        System.out.print(findStrToNumber(str)+" ");*/
    }
}