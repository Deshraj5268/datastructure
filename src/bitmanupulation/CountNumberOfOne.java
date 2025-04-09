package bitmanupulation;

/*https://www.geeksforgeeks.org/count-set-bits-in-an-integer/*/
public class CountNumberOfOne {

    public static void main(String[] args) {
        int n = 5;
        int result = countNumberOfOne(n);
        System.out.println("count number of 1's in "+n+" result "+result);
    }

    /*Brian Kernighan’s Algorithm q*/
    public static int countNumberOfOne(int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
