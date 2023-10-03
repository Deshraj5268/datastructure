package backtracking.recursion;

public class PrintNumber {

    public static void main(String[] args) {
        print1ToN(5);
        System.out.println();
        System.out.println("n to 1");
        reversePrint1ToN(5);
    }

    public static void print1ToN(int n){
        if(n == 0){
            return;
        }
        print1ToN(n-1);
        System.out.print(n+ " ");
    }

    public static void reversePrint1ToN(int n){
        if(n == 0){
            return;
        }
        System.out.print(n+ " ");
        reversePrint1ToN(n-1);
    }
}
