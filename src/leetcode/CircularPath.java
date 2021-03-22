package leetcode;


import java.util.ArrayList;
import java.util.List;

/*https://www.youtube.com/watch?v=dq6P01CbB-8*/
public class CircularPath {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("GLGLGLG");
        list.add("GLLG");
        for(String moves:list) {
            System.out.println(isCircular(moves));
        }

    }

    /*
    *            N(=0)
    *            |
    *(=3) W------|-------E(=1)
    *            |
    *            S(=2)
    *   R Moves:
    * N(0)->R : E(1)
    * E(1)->R : S(2)
    * S(2)->R : W(3)
    * W(3)->R : N(0)
    *  dir = (dir+1)%4
    *
    *  L Moves:
     * N(0)->L : W(3)
     * W(3)->L : S(2)
     * S(2)->L : E(1)
     * E(1)->L : N(0)
     *  dir = (4+dir-1)%4
    *
    *
    *
    * */
    public static boolean isCircular(String moves){
        int N=0;
        int E=1;
        int S=2;
        int W=3;
        int x=0;
        int y=0;
        int dir=N;
        char move;
        for(int i=0;i<moves.length();i++){
            move =moves.charAt(i);

            if(move == 'R'){
                dir = (dir+1)%4;
            }else if(move == 'L'){
                dir = (4+dir-1)%4;
            }else{ // G
                if(dir == N){
                    y++;
                }else if(dir == E){
                    x++;
                }else if(dir == S){
                    y--;
                }else {// W
                    x--;
                }
            }
        }
        return ((x == 0 && y == 0) || dir != N);//dir != N we ended at starting point
    }
}
