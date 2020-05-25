package arrays.rearrange;

import arrays.Utility;

public class NextGreaterEleWithSameSetOfDigit {

    public static void main(String[] args) {
        char digits[] = { '5','3','4','9','7','6' };
        System.out.println(nextGreaterEleWithSameSetOfDigit(digits));
    }

    public static String nextGreaterEleWithSameSetOfDigit(char [] numberCharArr){
        int length = numberCharArr.length;
        int n = length-1;
        //scan from the last
        while (n>0){
            if(numberCharArr[n-1] < numberCharArr[n]){
                break;
            }
            n--;
        }
        if(n == 0){
            System.out.println("not possible ");
        }
        int toBeReplace = numberCharArr[n-1];
        int min = n;
        for(int i = n+1;i<length;i++){
            if(numberCharArr[i] > toBeReplace && numberCharArr[min] > numberCharArr[i]){
                min = i;
            }
        }
        Utility.swap(numberCharArr,n-1,min);
        //reverse n to length
        int h = length-1;
        while (n < h){
            Utility.swap(numberCharArr,n,h);
            n++;
            h--;
        }
        return new String(numberCharArr);
    }
}
