package arrays.sortingsearching;

import java.util.Arrays;

public class MinPlatform {

    public static void main(String[] args) {

        int [] arr = {900, 940, 950, 1100, 1500, 1800};
        int [] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int minPlatform = minPlatform(arr,dep);
        System.out.println(minPlatform);

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
