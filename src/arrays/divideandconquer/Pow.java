package arrays.divideandconquer;

public class Pow {

    //a^n
    public static int powBasic(int a,int n){
        int result = 1;
        for(int i=0;i<n;i++){
            result *= a;
        }
        return result;
    }

    public static int pow(int a,int n){
        if(n == 0){
            return 1;
        }
        int temp = pow(a,n/2);
        temp = temp * temp;
        if(n % 2 == 1){
            temp = temp * a;
        }
        return temp;
    }

    public static void main(String[] args) {

        int a = 2;
        int n = -5;
        double result;
        result = powBasic(a,Math.abs(n));
        if(n < 0){
            result = 1/result;
        }
        System.out.println("Power of a:"+a+",n :"+n+" is : "+result);
        result = pow(a,Math.abs(n));
        if(n < 0){
            result = 1/result;
        }
        System.out.println("Optimized method Power of a:"+a+",n :"+n+" is : "+result);

    }
}
