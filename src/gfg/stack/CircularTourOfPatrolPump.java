package gfg.stack;

public class CircularTourOfPatrolPump {

    public static void main(String[] args) {

        int [] petrol = {4,6,7,4};
        int [] distance = {6,5,3,5};
    }

    /*public static int tour(int petrol[], int distance[]){
        if(petrol == null || petrol.length == 0){
            return -1;
        }
        int n = petrol.length;
        int count = 0;
        int currentPetrolAvailability = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            j = i;
            count = 0;
            currentPetrolAvailability = 0;
            while (j+1 != i){
                currentPetrolAvailability += petrol[j];
                if(currentPetrolAvailability < distance[j]){
                    break;
                }
                count++;
                if(j+1 == n){
                    j = 0;
                }
                j++;
            }
            if(count == n)
        }
    }*/

    /*public static int tour(int [] petrol,int [] distance){
        
    }*/
}
