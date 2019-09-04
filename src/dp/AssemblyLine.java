package dp;

public class AssemblyLine {

    public static int minCoastForCarAssembly(int [][] arr,int [][] time,int [] entry,int[] exit,int station,int line){
        int [] C1 = new int[station];//line 2
        int [] C2 = new int[station];//line 2
        C1[0] = arr[0][0]+entry[0];
        C2[0] = arr[1][0]+entry[1];

        for(int i=1;i<station;i++){
            C1[i] = Math.min((C1[i-1]+arr[0][i]),(C2[i-1]+arr[0][i]+time[1][i]));
            C2[i] = Math.min((C2[i-1]+arr[1][i]),(C1[i-1]+arr[1][i]+time[0][i]));
        }
        return Math.min((C1[station-1]+exit[0]),C2[station-1]+exit[1]);
    }

    public static void main(String[] args) {

        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12};
        int x[] = {18, 7};

        System.out.println(minCoastForCarAssembly(a, t, e, x,a[0].length,2));
    }
}
