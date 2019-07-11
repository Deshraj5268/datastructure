package dp;

public class UglyNumber {

    public static int maxDivide(int a,int b){
        while (a%b == 0){
            a = a/b;
        }
        return a;
    }
    public static boolean isUglyNumber(int n){
        n = maxDivide(n,2);
        n = maxDivide(n,3);
        n = maxDivide(n,5);
        return n == 1?true : false;
    }

    public static int uglyCount(int n){
        int count  = 1;
        int i = 1;
        while (n>count){
            i++;
            if(isUglyNumber(i)){
                count++;
            }
        }
        return i;
    }

    public static int uglyCountDp(int n){
        int i2=0,nextMultipleOf2 = 2;
        int i3=0,nextMultipleOf3 = 3;
        int i5=0,nextMultipleOf5 = 5;
        int [] ugly = new int[n];
        int nextUglyNumber = 1;
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            nextUglyNumber = Math.min(Math.min(nextMultipleOf2,nextMultipleOf3),nextMultipleOf5);
            ugly[i] = nextUglyNumber;
            if(nextUglyNumber == nextMultipleOf2){
                i2 = i2+1;
                nextMultipleOf2 = ugly[i2]*2;
            }
            if(nextUglyNumber == nextMultipleOf3){
                i3++;
                nextMultipleOf3 = ugly[i3]*3;
            }
            if(nextUglyNumber == nextMultipleOf5){
                i5++;
                nextMultipleOf5 = ugly[i5]*5;
            }
        }
        return nextUglyNumber;
    }

    public static void main(String[] args) {
        int n = 150;
        System.out.println("ugly number : "+uglyCount(n));
        System.out.println("ugly number using dp : "+uglyCountDp(n));
    }
}
