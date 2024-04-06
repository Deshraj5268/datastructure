package arrays.sortingsearching;

import java.util.Arrays;
import java.util.HashMap;

public class SortByAnotherArray {

    private static Integer [] sortByAnotherArray(int [] arr1Obj,int [] baseArr2Obj){

        Integer [] arr1 = Arrays.stream(arr1Obj).boxed().toArray(Integer[]::new);
        Integer[] basedArr2 = Arrays.stream(baseArr2Obj).boxed().toArray(Integer[]::new);

        HashMap<Integer,Integer> hashMap = prepareValIndexMap(basedArr2);
        Arrays.sort(arr1,(o1,o2)->{
            Integer x = hashMap.get(o1);
            Integer y = hashMap.get(o2);
            if(x!= null && y!= null){
                return x>y?1:-1; // positive ->swap, ascending order
            }else if(x!=null){
                return -1;
            }else if(y!=null){
                return 1;
            }else {
                return -1; //o1-o2 do nothing
            }
        });
     return arr1;

    }

    private static HashMap<Integer, Integer> prepareValIndexMap(Integer[] basedArr2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<basedArr2.length;i++){
            hashMap.putIfAbsent(basedArr2[i],i);
        }
        return hashMap;
    }

    public static void main(String[] args) {
        int [] arr1= {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int [] baseArr2 = {2, 1, 8, 3};

        System.out.println("arr1 : "+Arrays.toString(arr1));
        System.out.println("arr2 : "+Arrays.toString(baseArr2));
        Integer [] arr1Obj =  sortByAnotherArray(arr1,baseArr2);
        System.out.println(Arrays.toString(arr1Obj));

    }
}
