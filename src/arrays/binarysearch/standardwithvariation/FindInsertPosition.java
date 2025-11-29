package arrays.binarysearch.standardwithvariation;

public class FindInsertPosition {

    public static void main(String[] args) {
        int [][] mat ={{1,3,5,6},{1,3,5,6}};
        int [] kPosition = {2,5};
        int index;
        for(int i = 0;i<mat.length;i++){
            index = searchInsertK(mat[i], mat[i].length, kPosition[i]);
            System.out.println("correct index for "+kPosition[i] +" is "+index);
        }
    }

    public static int searchInsertK(int arr[], int N, int k)
    {
        // code here
        int l = 0;
        int h = N-1;
        int m = 0;
        while(l<=h){
            m = l+(h-l)/2;
            if(arr[m] == k){
                return m;
            }else if(arr[m] < k){
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return l;
    }
}
