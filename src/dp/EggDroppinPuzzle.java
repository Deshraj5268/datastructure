package dp;



/*
*find the critical floor, but merely to decide floors from which eggs should be dropped
* so that total number of trials are minimized.
* */
public class EggDroppinPuzzle {

    //n : # eggs , k : floors
    public int eggDropping(int n,int k){
        if(k == 0 || k==1){
            return k;
        }
        if(n == 1){
            return k;
        }
        int res;
        int min=Integer.MAX_VALUE;
        int x ;
        for(x = 1;x<=k;x++){
            res = Math.max(eggDropping(n-1,x-1),eggDropping(n,k-x));
            if(min > res){
                min = res;
            }
        }
        return min+1;
    }

    public int eggDroppingDp(int n,int k){
        int [][] arr = new int[n+1][k+1];
        for(int i=1;i<n;i++){
            arr[i][0] = 0;
            arr[i][1] = 1;
        }
        for(int j=1;j<=k;j++){
            arr[1][j]=j;
        }
       // int min= Integer.MAX_VALUE;
        int res;
        for(int i = 2;i<=n;i++){
            for(int j=2;j<=k;j++){
                arr[i][j]= Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    res = 1+ Math.max(arr[i-1][x-1],arr[i][j-x]);
                    if(arr[i][j] > res){
                        arr[i][j] = res;
                    }
                }
            }
        }
        return arr[n][k];

    }


    public static void main(String[] args) {
        EggDroppinPuzzle eggDroppinPuzzle = new EggDroppinPuzzle();
        int n = 2;
        int k = 10;
        int result = eggDroppinPuzzle.eggDropping(n,k);
        System.out.println(result);
        System.out.println("Using DP : "+eggDroppinPuzzle.eggDroppingDp(n,k));
    }
}
