package arrays.others;

import java.util.ArrayList;

class Stock{
    int sell;
    int buy;
}

public class StockBuyAndSell {

    /*
    * find local minima and local maxima and store it
     */
    public static ArrayList<Stock> stockBuyAndSell(int [] priceArr){
        if(priceArr == null || priceArr.length == 0){
            return null;
        }
        int n = priceArr.length;
        if(n == 1){
            return null;
        }
        ArrayList<Stock> stocksArr = new ArrayList<>((n/2)+1);
        int i=0;
        int count = 0;
        while (i<n-1){
            Stock stock = new Stock();
            while (i<n-1 && priceArr[i] >= priceArr[i+1]){
                i++;
            }
            if(i == n-1){
                break;
            }
            stock.buy = i++;
            while (i<n && priceArr[i] >= priceArr[i-1]){
                i++;
            }
            stock.sell = i-1;
            stocksArr.add(stock);
            //count++;
        }
        return stocksArr;
    }

    public static void main(String[] args) {
        int [] priceArr = { 100, 180, 260, 310, 40, 535, 695};
        ArrayList<Stock> stockArr = stockBuyAndSell(priceArr);
        if(stockArr != null) {
            for (int i = 0; i < stockArr.size(); i++) {
                System.out.println(stockArr.get(i).buy + ": " + stockArr.get(i).sell);
            }
        }
    }
}
