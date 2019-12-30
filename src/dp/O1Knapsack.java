package dp;

import java.util.Arrays;

public class O1Knapsack {

    public static int [][] tabKnapsack;
    public static int [][] optTabKnapsack;

    public static int o1Knapsack(int [] val,int [] wt,int n,int w){
        if(w == 0 || n == 0){
            return 0;
        }
        if(wt[n-1] > w){
            return o1Knapsack(val,wt,n-1,w);
        }
        else {
            int a = o1Knapsack(val,wt,n-1,w);
            int b = o1Knapsack(val,wt,n-1,w-wt[n-1])+val[n-1];
            return Math.max(a,b);
        }
    }
    public static int o1KnapsackTabulation(int [] val,int [] wt,int n,int w){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i == 0 || j == 0){
                    tabKnapsack[i][j] = 0;
                }else if(wt[i-1] <= j){
                    tabKnapsack[i][j] = Math.max(val[i-1]+tabKnapsack[i-1][j-wt[i-1]],tabKnapsack[i-1][j]);
                }else {
                    tabKnapsack[i][j] = tabKnapsack[i-1][j];
                }
            }
        }
        return tabKnapsack[n][w];
    }

    public static int o1KnapsackTabulationSpaceOpt(int [] val,int [] wt,int n,int w){
        int k = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i == 0 || j == 0){
                    continue;
                }else if(wt[i-1] <= j){
                    optTabKnapsack[(k+1)%2][j] = Math.max(val[i-1]+optTabKnapsack[k%2][j-wt[i-1]],optTabKnapsack[k%2][j]);
                }else {
                    optTabKnapsack[(k+1)%2][j] = optTabKnapsack[k%2][j];
                }
            }
            k++;
        }
        return optTabKnapsack[k%2][w];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println("recursive  : "+o1Knapsack(val,wt,n,w));
        //tabulation
        tabKnapsack = new int [n+1][w+1];
        System.out.println("tablation   : "+o1KnapsackTabulation(val,wt,n,w));
        /*for (int i=0;i<tabKnapsack.length;i++)
        System.out.println(Arrays.toString(tabKnapsack[i]));*/

        optTabKnapsack = new int[2][w+1];
        System.out.println("tabulation with optimize space   : "+o1KnapsackTabulationSpaceOpt(val,wt,n,w));

    }
}
