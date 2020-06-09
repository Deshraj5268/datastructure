package stack;


import java.util.Arrays;

/*https://medium.com/algorithms-and-leetcode/best-time-to-buy-sell-stocks-on-leetcode-the-ultimate-guide-ce420259b323*/
public class StockAllProblem {

    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println(Arrays.toString(arr));
        stockBuyAndSellFirst(arr);

        arr = new int []{1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(Arrays.toString(arr));
        stockBuyAndSellSecond(arr);

    }

    private static boolean isEmptyArr(int [] arr){
        return (arr == null || arr.length < 2); // less than no useful
    }

    /*
    * scenario 1 : buy and sell a single stock to maximize the profit
    * */
    public static void stockBuyAndSellFirst(int [] arr){
        if(isEmptyArr(arr)){
            return;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minStock = arr[0];
        for (int i=1;i<arr.length;i++){
            //maxProfit = Math.max(maxProfit,arr[i]-minStock);
            // minStock = Math.min(minStock,arr[i]);
            if(maxProfit < arr[i]-minStock){
                maxProfit = arr[i]-minStock;
            }
            if(minStock > arr[i]){
                minStock = arr[i];
            }
        }
        System.out.println("max profit for 1 time buy and sell :"+maxProfit);
    }

    /*
    * stock buy and sell multiple time but most one stock can be there in hand all the time
    * profit sum
    * */
    public static void stockBuyAndSellSecond(int [] arr){
        if(isEmptyArr(arr)){
            return;
        }
        int profitSum = 0;
        for(int i=1;i<arr.length;i++){
            profitSum += Math.max(arr[i]-arr[i-1],0);
        }
        System.out.println("profit sum where buy and sell multiple time : "+profitSum);
    }
}
