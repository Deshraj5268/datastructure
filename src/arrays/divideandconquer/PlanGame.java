package arrays.divideandconquer;

import java.util.Arrays;

/*
*
* In a game , each plane has a starting position above the ground level and a
* speed at which it is decending. The player character has a gun that can shoot
* one aircraft each second. The game will end if any plane lands. Determine the
* maximum number of planes that can be prevented from landing.
* */
public class PlanGame {

    public static void main(String[] args) {
        int[] height = {4, 3, 5};
        int[] speed = {1, 2, 1};
        System.out.println("Maximum planes prevented: " + maxPlanesPrevented(height, speed));
    }

    /*
    *
    * Compute the time each plane will land.
        Sort planes by their landing times (ascending).
        Iterate through planes in sorted order:
        At second t, if timeToLand >= t, shoot it.
        Else → plane has already landed → stop.
        Count how many were shot.
    * */
    private static int maxPlanesPrevented(int[] height, int[] speed) {

        double [] timeToLand = new double[height.length];
        for(int i=0;i<height.length;i++){
            timeToLand[i] = (double) height[i]/speed[i];
        }
        Arrays.sort(timeToLand);
        System.out.println("timeToLand Array :"+Arrays.toString(timeToLand));
        int preventedCount = 0;
        int currentTime = 0; // sec
        for(int i=0;i<timeToLand.length;i++){
            if(timeToLand[i] >= currentTime){
                preventedCount++;
                currentTime++;
            }else {
                break;
            }
        }
        return preventedCount;
    }
}
