package leetcode.topinterviewquestion150;

public class LemonadeChange_860 {

    public static void main(String[] args) {
        int [] bills = {5,5,10};
        boolean result = lemonadeChange(bills);
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveBill=0,tenBill=0;
        for(int bill:bills){
            if(bill == 5){
                fiveBill++;
            }else if(bill == 10){
                if(fiveBill>0){
                    fiveBill--;
                    tenBill++;
                }else{
                    return false;
                }
            }else { // 20
                if(fiveBill > 0 && tenBill>0){
                    fiveBill--;
                    tenBill--;
                }else if(fiveBill>=3){
                    fiveBill-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
