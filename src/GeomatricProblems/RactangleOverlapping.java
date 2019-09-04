package GeomatricProblems;

import java.util.Scanner;
public class RactangleOverlapping
{
    public static int isRectangleOverlapping(int l1x,int l1y,int r1x,int r1y,int l2x,int l2y,int r2x,int r2y){

        if(l1x>r2x || r1x>l2x){
            return 0;
        }
        if(l1y<l2y || r1y>l2y){
            return 0;
        }
        return 1;
    }

    public static void main (String[] args)
    {
        //code
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            int l1x = sc.nextInt();
            int l1y = sc.nextInt();
            int r1x = sc.nextInt();
            int r1y = sc.nextInt();
            int l2x = sc.nextInt();
            int l2y = sc.nextInt();
            int r2x = sc.nextInt();
            int r2y = sc.nextInt();
            System.out.println(isRectangleOverlapping(l1x,l1y,r1x,r1y,l2x,l2y,r2x,r2y));

            t--;
        }
    }
}