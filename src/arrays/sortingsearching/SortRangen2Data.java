package arrays.sortingsearching;

public class SortRangen2Data {


    public static String baseConversion(String number,
                                        int sBase, int dBase)
    {
        // Parse the number with source radix
        // and return in specified radix(base)
        return Integer.toString(
                Integer.parseInt(number, sBase),
                dBase);
    }

    public static int BeseConv(int val,int base){
        int temp = 0;
        while (val % base != 0){
            temp = temp*10 + (val % base);
            val /= base;
        }
        int result = 0;
        while (temp != 0){
            result = result*10 +(temp % 10);
            temp /=10;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 12; // Number
        int sBase = 5; // Source Base Octal
        int dBase = 10; // Destination Base Decimal
        System.out.println("base " +BeseConv(number,sBase));
    }
}
