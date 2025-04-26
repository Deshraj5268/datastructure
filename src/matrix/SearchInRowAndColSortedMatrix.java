package matrix;


/*
* https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/#expected-approach-removing-row-or-column-in-each-comparison-on-time-and-o1-space
* */
public class SearchInRowAndColSortedMatrix {

    public static void main(String[] args) {
        int mat3D [][][] ={
                {
                        {3, 30, 38},
                        {20, 52, 54},
                        {35, 60, 69}
                },
                {
                        {3, 30, 38},
                        {20, 52, 54},
                        {35, 60, 69}
                }
        };

        int [] targets = {62, 35};
        for(int i=0;i<mat3D.length;i++){
            boolean result = matSearch(mat3D[i], targets[i]);
            boolean result1 = searchInMatrix(new int [][]{{1,1}}, 2);
            System.out.println("result : "+result);
            System.out.println(result1);
        }

    }


    /*
    * Approaches :
    * 1. Search in matrix O(n*m)
    * 2.Search in every row using binary search (n * Log m)
    * 3. rows and cols is sorted , so we can start with top right corner
    *    if data less than then col--
    *    else row++
    *  complexity : (M + N)
    * */

    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row, col, tRow;
        tRow = mat.length;
        row = 0;
        col = mat[0].length-1;
        // row and col are sorted so start from top right corner ( 0, tCol)
        while(row < tRow && col >=0){
            if(mat[row][col] == x){
                return true;
            }else if(mat[row][col] < x){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    /*
    * https://leetcode.com/problems/search-a-2d-matrix/
    * row is sorted and column and next element is row also sorted
    * 1 2 3
    * 4 5 7
    * 9 10 11
    *
    * https://www.youtube.com/watch?v=x-dYOtIudzc
    *
    * Above solution work, we can use binary search in 2d array
    *  if we add column ( m) then we form 1D array of all element
    * so if say we have total (m*n -1) element
    * then mid = (l+h)/2
    * row position in matrix = mid/m { m is column) [ because all m == total row]
    * col = mid% m
    * */
    public static boolean searchInMatrix(int [][] mat , int target){
        int m = mat.length;
        int n = mat[0].length;
;        int l=0;
        int h = m*n - 1;
        int mid;
        int row, col;
        while (l<h){
            mid = l+ (h-l)/2;
            row =  mid/n; // n is col
            col = mid%n;
            if(mat[row][col] == target){
                return true;
            }else if(mat[row][col] < target){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return false;
    }
}
