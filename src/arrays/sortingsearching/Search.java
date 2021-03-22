package arrays.sortingsearching;

public class Search {

    public int linearSearch(int [] arr,int l,int r,int data){
        if(arr == null || arr.length == 0){
            return -1;
        }
        while (l<=r){
            if(arr[l] == data){
                return l;
            }
            l++;
        }
        return -1;
    }
}
