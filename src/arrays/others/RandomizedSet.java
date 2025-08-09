package arrays.others;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    Random random;
    List<Integer> list;


    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(1);
        boolean param_4 = obj.insert(2);
        System.out.println(obj.getRandom());
        boolean param_5 = obj.remove(1);
        boolean param_6 = obj.insert(3);
        System.out.println(obj.getRandom());

    }
    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        map.put(lastVal(), index);
        map.remove(val);

        int lastIndex = list.size()-1;
        list.set(index, list.get(lastIndex));
        list.remove(lastIndex);
        return true;
    }

    private int lastVal(){
        return list.get(list.size() -1);
    }

    public int getRandom() {
        int ranVal = random.nextInt(list.size());
        return list.get(ranVal);
    }
}
