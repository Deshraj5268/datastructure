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

    public static int findWeightedSet(int [] parent,int i){
        //weight or path length or rank will added in negative way
        if(parent[i] < 0){
            return i;
        }
        return findWeightedSet(parent,parent[i]);
    }

    public static int findPathSet(int [] parent,int i){
        //weight or path length or rank will added in negative way
        if(parent[i] == -1){
            return i;
        }
        int x =  findPathSet(parent,parent[i]);
        parent[i] = x;
        return x;
    }

    public static void unionWeightedSet(int [] parent,int x,int y){
        int xIndex = x;//findWeightedSet(parent,x);
        int yIndex = y;//findWeightedSet(parent,y);
        //find the parent
        //x will be the parent
        if(Math.abs(parent[xIndex]) > Math.abs(parent[yIndex])){
            parent[xIndex] += parent[yIndex]; // index value always be negative
            parent[yIndex] = xIndex;
        }else /*if(Math.abs(parent[xIndex]) < Math.abs(parent[yIndex]))*/ {
            parent[yIndex] += parent[xIndex];
            parent[xIndex] = yIndex;
        }
    }

    public static void unionSet(int [] parent,int x,int y){
        int xSet = findSet(parent,x);
        int ySet = findSet(parent,y);
        parent[ySet] = xSet;
    }

    public static void unionPathSet(int [] parent,int x,int y){

        parent[x] = y;
    }
}
