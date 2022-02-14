package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ATMQueue {
    public static void main(String[] args) {


        int [][] mat = {
                {2,7,4},
                {9,10,4,7,2}
        };
        int [] kArr = {3,6};
        for(int i=0;i<mat.length;i++){
            List<Integer> result = atmWithdrawalQueue(kArr[i], Arrays.stream(mat[i]).boxed().collect(Collectors.toList()));
           result.stream().forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }

    public static List<Integer> atmWithdrawalQueue(int k,List<Integer> atmQueue){
        List<Person> personList = new ArrayList<>();
        Iterator<Integer> itr = atmQueue.iterator();
        List<Integer> result = new ArrayList<>();
        int i = 1;
        Person person = null;
        while (itr.hasNext()){
            double data = (double)itr.next()/k;
            person = new Person(i,(int)Math.ceil(data));
            personList.add(person);
            i++;
        }
        personList.sort((x,y)->(x.count == y.count && x.pos>y.pos) ? 1:Integer.compare(x.count,y.count));
        personList.stream().forEach(x->result.add(x.pos));
        return result;
    }
}

class Person{
    int pos;
    int count;

    public Person(int pos,int count){
        this.pos = pos;
        this.count = count;
    }
}
