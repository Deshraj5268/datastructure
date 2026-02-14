package dp.fibonacci;


//https://r-knott.surrey.ac.uk/Fibonacci/brickEXPLAIN.html
public class BrickProblem {

    public static void main(String[] args) {
        System.out.println(countWay(5));
    }


    // fibonacci series
    /* brick len = 1, h = 2 ( on e brick param)
    * n = 1, ans =1   I ( 1)
    * n =2 , ans = 2---> II , =  ( 2 ways)
    * n= 3 , ans = 3 --> III , I= , =I ( 3 ways)
    * n = 4 , ans = 5 -->  IIII , I=I, =II , II= , == ( 5 ways)
    * n = 5 , 8 (ways)
    * 1 ,2 ,3 ,5 8, 13 ---? fibonacci
    * */
    public static int countWay(int bricks){
        if(bricks <=2){
            return bricks;
        }
        int first = 1;
        int second = 2;
        int totalWays = 0;
        for (int i = 3; i <= bricks ; i++) {
            totalWays = first + second;
            first = second;
            second = totalWays;
        }
        return totalWays;
    }
}
