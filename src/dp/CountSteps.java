package dp;

public class CountSteps {

    static int [] countMemo;
    public static void main(String[] args) {

        int n=8;
        System.out.println(countSteps(n));
        countMemo = new int[n+1];
        countMemo[0] = countMemo[1] = 1;
        countMemo[2] = 2;
        System.out.println(countStepsDp(n));

    }

    /*
    *          f(n)
    *     /     |      \
    * f(n-1)   f(n-2)  f(n-3)
    *
    * O(3^n)
    *
    * Another explanation
    * n = 0 ,(ans=1): {}
    * n = 1, (ans=1): {1}
    * n=2 ,(ans=2): {{1,1},{2}}
    * n=3 ,(ans=4):  { {1,1,1}, {2,1}
    *               {1,2}, {3} }
    * n= 4 (ans=7): { {1,1,1,1},{2,1,1},{1,2,1},{3,1} // using set{3}
    *                 {1,1,2},{2,2}                // using set{2}
    *                 {1,3}                       // using set{1}
    *               }
    *
    * so if n 2,4,5 steps so you can use same approach
    * */
    public static int countSteps(int n){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return countSteps(n-1) // count step using 1
                + countSteps(n-2) // count step using 2
                + countSteps(n-3); // count step using 3
    }

    public static int countStepsDp(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(countMemo[n] != 0){
            return countMemo[n];
        }
        countMemo[n] = countStepsDp(n-1)+
                countStepsDp(n-2)+
                countStepsDp(n-3);
        return countMemo[n];
    }
}
