package arrays.others;


import java.util.Arrays;

/*https://medium.com/algorithms-and-leetcode/best-time-to-buy-sell-stocks-on-leetcode-the-ultimate-guide-ce420259b323
* https://www.youtube.com/watch?v=excAOvwF_Wk
* */
public class StockAllProblem {

    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println(Arrays.toString(arr));
        stockBuyAndSellFirst121(arr);

        arr = new int []{1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(Arrays.toString(arr));
        stockBuyAndSellSecond122(arr);

        arr = new int [] {3,3,5,0,0,3,1,4};
        System.out.println(Arrays.toString(arr));
        stockBuyAndSellThird123(arr);

    }

    private static boolean isEmptyArr(int [] arr){
        return (arr == null || arr.length < 2); // less than no useful
    }

    /*
    * scenario 1 : buy and sell a single stock to maximize the profit
    * */
    public static void stockBuyAndSellFirst121(int [] arr){
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
    public static void stockBuyAndSellSecond122(int [] arr){
        if(isEmptyArr(arr)){
            return;
        }
        int profitSum = 0;
        for(int i=1;i<arr.length;i++){
            profitSum += Math.max(arr[i]-arr[i-1],0);
        }
        System.out.println("profit sum where buy and sell multiple time : "+profitSum);
    }

    /*
    * Final Profit = (Initial Profit — Buying Price) + Selling Price
    * at most two transactions i.e.,  sell the stock before buying again
    * */
    public static void stockBuyAndSellThird123(int [] prices){
        int firstBuy,firstSell,secondBuy,secondSell;
        firstBuy = firstSell = secondBuy = secondSell = Integer.MIN_VALUE;

        for(int price:prices){
            firstBuy = Math.max(firstBuy,-price);
            firstSell = Math.max(firstSell, firstBuy+price);
            secondBuy = Math.max(secondBuy,firstSell-price);
            secondSell = Math.max(secondBuy,secondBuy+price);
        }
        System.out.println("profit sum where buy and sell multiple time at most two transactions : "+secondSell);

    }
}
