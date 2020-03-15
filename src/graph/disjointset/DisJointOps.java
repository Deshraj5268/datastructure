package graph.disjointset;

public class DisJointOps {

    private DisJointOps(){}

    public static int findSet(int [] parent,int i){
        //-1 is representative
        if(parent[i] == -1){
            return i;
        }
        return findSet(parent,parent[i]);
    }

    public static void unionSet(int [] parent,int x,int y){
        int xSet = findSet(parent,x);
        int ySet = findSet(parent,y);
        parent[xSet] = ySet;
    }
}
