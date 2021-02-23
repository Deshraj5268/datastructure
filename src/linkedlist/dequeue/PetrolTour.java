package linkedlist.dequeue;

public class PetrolTour {



    public static void main(String[] args) {

        int [] petrol = {6,7,4,10,6};
        int [] distance = {5,6,7,8,6};
        System.out.println(petrolPumpTour(petrol,distance));
        System.out.println(petrolTour(petrol,distance));
        System.out.println(tourOptimize(petrol,distance));

    }


    //brute force
    public static int petrolPumpTour(int petrol[], int distance[]){
        // Your code here
        int sum = 0;
        int i=0;
        int j=0;
        int n = petrol.length;
        while(i<n){
            sum = 0;
            sum+= petrol[i]-distance[i];
            j=i;
            j = (j+1)%n;
            while(i!=j && sum>=0){
                sum+= (petrol[j]-distance[j]);
                j = (j+1)%n;
            }
            if(sum>=0){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int petrolTour(int [] petrol,int [] distance){
        if(petrol == null || distance == null || (petrol.length != distance.length)){
            return -1;
        }
        if(petrol.length == 1 && petrol[0] >0){
            return 0;
        }
        int s = 0;
        int e = 1;
        int n = petrol.length;
        int currentPetrol = petrol[s]-distance[s];
        while (s != e || currentPetrol < 0){

            while (currentPetrol < 0 && s != e){
                currentPetrol -= (petrol[s]-distance[s]);
                s = (s+1)%n;
                if(s == 0){
                    return -1;
                }
            }

            currentPetrol += (petrol[e]-distance[e]);
            e = (e+1)%n;
        }
        return s;
    }

    /*
    * https://www.youtube.com/watch?v=zcnVaVJkLhY
    * */
    public static int tourOptimize(int petrol[], int distance[])
    {
        // Your code here
        int sum = 0;
        int n = petrol.length;
        int s = 0;
        int diff = 0;
        for(int i=0;i<n;i++){
            sum += (petrol[i]- distance[i]);
            if(sum<0){
                s = i+1;
                diff += sum;
                sum = 0;
            }
        }

        return (sum+diff)>=0?s:-1;

    }
}
