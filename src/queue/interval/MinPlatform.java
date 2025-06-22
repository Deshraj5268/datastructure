package queue.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinPlatform {

    public static void main(String[] args) {

        int [] arr = {900, 940, 950, 1100, 1500, 1800};
        int [] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int minPlatform = minPlatform(arr,dep);
        System.out.println(minPlatform);
        minPlatform = minPlatformWithMinHeap(arr,dep);
        System.out.println("minPlatform using minHeap "+minPlatform);
        minPlatform = minPlatFormWithoutExtraSpace(arr,dep);
        System.out.println("minPlatform using minPlatFormWithoutExtraSpace "+minPlatform);

    }

    public static int minPlatform(int [] arrival,int [] departure){
        ArrDeptInfo [] arrDeptInfos= new ArrDeptInfo[arrival.length*2];
        int j = 0;
        for(int i=0;i<arrival.length;i++){
            ArrDeptInfo  arrDeptInfo = new ArrDeptInfo(arrival[i],true);
            arrDeptInfos[j] = arrDeptInfo;
            j++;
            ArrDeptInfo deptInfo = new ArrDeptInfo(departure[i],false);
            arrDeptInfos[j] = deptInfo;
            j++;
        }

        Arrays.sort(arrDeptInfos,(x,y)->x.value>y.value ? 1:-1);
        int minPlatform = 0;
        int countPlatform = 0;
        for(ArrDeptInfo arrDeptInfo:arrDeptInfos){
            if(arrDeptInfo.isArrival){
                countPlatform++;
            }else {
                countPlatform--;
            }
            if(minPlatform<countPlatform){
                minPlatform = countPlatform;
            }
        }
        return minPlatform;
    }

    public static int minPlatFormWithoutExtraSpace(int [] arrival,int [] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int n = arrival.length;
        int i=1;
        int j = 0;
        int result = 1;
        int minPlatForm = 1;
        while(i < n && j < n){
            if(departure[j] >= arrival[i]){
                minPlatForm++;
                i++;
            }else{
                minPlatForm--;
                j++;
            }
            if(minPlatForm > result){
                result = minPlatForm;
            }
        }
        return result;
    }


    /*
    *  sort based on arrival time
    * add first endTIme
    * check all newArrival <= minHeap.peek() then increase counter
    *  else poll the data from queue
    *  add endTime in minQueue
    * */
    public static int minPlatformWithMinHeap(int [] arrival,int [] departure){
        int [][] arrDep = new int[arrival.length][2];

        for(int i=0;i<arrival.length;i++){
            arrDep[i][0] = arrival[i];
            arrDep[i][1] = departure[i];
        }
        Arrays.sort(arrDep,(x,y)->x[0]-y[0]); // sort based on arrival time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(arrDep[0][1]); // added first dept time
        int minPlat=1;
        for(int i=1;i<arrDep.length;i++){

            if(arrDep[i][0] <= minHeap.peek()){ // second Arrival onboard are less than the min of Departure then inc count
                minPlat++;
            }else{
                minHeap.poll();
            }
            minHeap.add(arrDep[i][1]);
        }
        return minPlat;
    }
}

class ArrDeptInfo{
    int value;
    boolean isArrival;

    public ArrDeptInfo(int value, boolean isArrival) {
        this.value = value;
        this.isArrival = isArrival;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
