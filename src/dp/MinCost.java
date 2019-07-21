package dp;

public class MinCost {

    public static int minCost(int [][] costArr ,int m,int n){
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        if(m == 0 && n == 0){
            return costArr[m][n];
        }
        return costArr[m][n] + minOfThree(minCost(costArr,m-1,n-1),minCost(costArr,m-1,n),minCost(costArr,m,n-1) );
    }

    public static int minOfThree(int x,int y,int z){
        return Math.min(Math.min(x,y),z);
    }

    //n,m are inclusive
        public static int minCostDP(int [][] costArr,int m,int n){
        if(costArr == null || costArr.length == 0){
            return 0;
        }
        int [][] tab = new int [m+1][n+1];
        tab[0][0]=costArr[0][0];

        //data insertion in column
        for(int j=1;j<=n;j++){
            tab[0][j] = tab[0][j-1]+costArr[0][j];
        }
        for(int i=1;i<=m;i++){
            tab[i][0] = tab[i-1][0]+costArr[i][0];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                tab[i][j] = minOfThree(tab[i-1][j-1],tab[i-1][j],tab[i][j-1])+costArr[i][j];
            }
        }
        return tab[m][n];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int [][] costArr = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        System.out.println(minCost(costArr,m-1,n-1));
        System.out.println("using Dp :"+minCostDP(costArr,m-1,n-1));
    }
}
