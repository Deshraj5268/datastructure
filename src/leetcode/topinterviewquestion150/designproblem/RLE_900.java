package leetcode.topinterviewquestion150.designproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class RLE_900 {

    List<Integer> list;
    TreeMap<Integer,Integer> countValueTreeMap;
    int index;
    int count;

    int [] tab;

    public RLE_900(){
        index = 0;
        list = new ArrayList<>();
        countValueTreeMap = new TreeMap<>();
    }
    public static void main(String[] args) {

        int [][] encoding = {{3, 8, 0, 9, 2, 5},
        };
        int [][] nextQueries = {{2,1,1,2}};
        for (int i=0;i<encoding.length;i++){
            RLE_900 rle900 = new RLE_900();
            System.out.println("input : "+ Arrays.toString(encoding[i]));
            rle900.initialization(encoding[i]);
            for (int j=0;j<nextQueries[i].length;j++) {
                int result = rle900.next(nextQueries[i][j]);
                System.out.println("result : " + result);
            }
        }
        System.out.println("optimize : ");
        for (int i=0;i<encoding.length;i++){
            RLE_900 rle900 = new RLE_900();
            System.out.println("input : "+ Arrays.toString(encoding[i]));
            rle900.initializationOpt(encoding[i]);
            for (int j=0;j<nextQueries[i].length;j++) {
                int result = rle900.nextOpt(nextQueries[i][j]);
                System.out.println("result : " + result);
            }
        }

        System.out.println("optimize 2 : ");
        for (int i=0;i<encoding.length;i++){
            RLE_900 rle900 = new RLE_900();
            System.out.println("input : "+ Arrays.toString(encoding[i]));
            rle900.initializationOpt1(encoding[i]);
            for (int j=0;j<nextQueries[i].length;j++) {
                int result = rle900.nextOpt1(nextQueries[i][j]);
                System.out.println("result : " + result);
            }
        }
    }

    public void initialization(int [] encoding){
        for(int i=0;i<encoding.length;i+=2){
            for(int j=0;j<encoding[i];j++){
               if(encoding[i]>0) {
                   list.add(encoding[i+1]);
               }
            }
        }
    }

    public void initializationOpt(int [] encoding){
        int count = 0;
        for(int i=0;i<encoding.length;i+=2){
            if(encoding[i]>0) {
                count += encoding[i];
                countValueTreeMap.put(count, encoding[i+1]);
            }
        }
    }

    public int next(int n){
        index+=n;
        return index < list.size() ? list.get(index-1): -1;
    }

    public int nextOpt(int n){
        index+=n;
        Integer ceilingKey = countValueTreeMap.ceilingKey(index);
        return ceilingKey!=null ? countValueTreeMap.get(ceilingKey): -1;
    }

    public void initializationOpt1(int [] encoding){
        tab = encoding;
        index = 0;
    }

    // keep track of prev index
    public int nextOpt1(int n){
        while (index < tab.length) {
            if (n > tab[index]) {
                n -= tab[index];
                index += 2;
            } else {
                tab[index] -= n;
                return tab[index + 1];
            }
        }
        return -1;
    }


    public void initializationOpt2(int [] encoding){
        tab = encoding;
        index = 0;
        count = tab[0];
    }

    // keep track of prev index
    public int nextOpt2(int n){
        while (index < tab.length) {
            if (n > count) {
                n -= count;
                index += 2;
                if(index < tab.length){
                    count = tab[index];
                }
            } else {
                count -= n;
                return tab[index + 1];
            }
        }
        return -1;
    }


}
