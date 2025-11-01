package arrays.divideandconquer;

public class PrimeNUmber {

    public static void main(String[] args) {
        int [] primes = {2,3,5,19,20};
        for(int i=0;i<primes.length;i++){
            System.out.println(primes[i]+" isPrime :"+isPrime(primes[i]));
        }
    }

    public static boolean isPrime(int n){

        if(n == 1){
            return false;
        }
        if(n == 2){
            return true;
        }
        if(n%2 == 0){
            return false;
        }
        int sqrtN = (int)Math.sqrt(n);
        for(int i=3;i<=sqrtN;i+=2){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
