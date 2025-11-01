package arrays.binarysearch.multplyby2;

public class DollarPosition {


    public static void main(String[] args) {
        char [] arr = {'7','5','2','4','6', '7','2','4','6', '7','2','4','6', '7','2','4','6', '7'
        ,'$','$','$','$','$','$','$','$','$','$','$','$','$','$'};
        int dollarIndex = findStartingPosition(arr, '$');
        System.out.println(dollarIndex);
    }

    public static int findStartingPosition(char [] arr, char symbol){
        int prev = 0;
        int n = arr.length;
        int i=1;
        if(arr[0] == symbol){
            return 0;
        }
        while (i< n && arr[i] != symbol){
            prev = i;
            i = 2*i;
        }
        return findDollarUsingBST(arr, prev, i, symbol);
    }

    private static int findDollarUsingBST(char[] arr, int prev, int i, char symbol) {
        int start = prev;
        int end = i;
        int mid;

        while (start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] == symbol && arr[mid-1] != symbol){
                return mid;
            }else if(arr[mid] != symbol){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return start;
    }
}
