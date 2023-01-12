public class Test {

    static int [] tab;

    public static void main(String[] args) {
        int [] arr = {6, 7, 8, 9};//{5, 5, 10, 5};//{5, 9, 10, 10};//{2,3,3,10};
        int n = arr.length;
        tab = new int[n+1];

       // int result = comboCount(arr,n,15);
        int i=0;
        while(true) {
            System.out.println(i);
           /* i++;
            if(i == Integer.MIN_VALUE){
                break;
            }*/
        }
    }

    public static  int   comboCount(int [] arr ,int n,int sum){
        if(sum == 0 ){
            return 1;
        }

        if(sum < 0 || n <=0 ){
            return 0;
        }
        if(tab[n] != 0){
            return tab[n];
        }

        tab[n] = comboCount(arr,n-1,sum) + comboCount(arr,n-1,sum-arr[n-1]);
        return tab[n];
    }
}
