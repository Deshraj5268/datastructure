package advanceds.segmenttree;

import java.util.Arrays;

public class MinSegmentTree {

    public static void main(String[] args) {
        int [] input = {1, 3, 2, 7, 9, 11};

        MinSegmentTree minSegmentTree = new MinSegmentTree();
        int [] segmentTree = minSegmentTree.segmentTree(input,input.length-1);
        System.out.println(minSegmentTree.rangeMinimumQuery(segmentTree,0,input.length-1,1,5,0));
    }

    private void constructSegmentTree(int [] input,int [] segmentTree, int low,int high,int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = getMid(low,high);
        constructSegmentTree(input,segmentTree,low,mid,2*pos+1);
        constructSegmentTree(input,segmentTree,mid+1,high,2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
    }

    public int [] segmentTree(int [] input,int n){
        int height = (int)(Math.ceil(Math.log(n)/Math.log(2))); // Loga(B) = log10 B / log10 a
        int segmentTreeSize = 2 * (int)(Math.pow(2,height)) - 1;
        int [] segmentTree = new int[segmentTreeSize];
        Arrays.fill(segmentTree,Integer.MAX_VALUE);
        constructSegmentTree(input,segmentTree,0,input.length-1,0);
        return segmentTree;
    }

    public int rangeMinimumQuery(int [] segmentTree,int low,int high,int qLow,int qHigh,int pos){
        if(isTotallyOverlapped(low,high,qLow,qHigh)){
            return segmentTree[pos];
        }
        if(isNoOverlapping(low,high,qLow,qHigh)){
            return Integer.MAX_VALUE;
        }
        int mid = getMid(low,high);
        return Math.min(rangeMinimumQuery(segmentTree,low,mid,qLow,qHigh,2*pos+1),
                rangeMinimumQuery(segmentTree,mid+1,high,qLow,qHigh,2*pos+2));
    }

    public void updateSegmentTree(int [] segmentTree,int index,int value,int low ,int high,int pos){
        //out off range
        if(index < low || index > high){
            return;
        }
        if(low == high){
            segmentTree[pos] += value;
            return;
        }
        int mid = getMid(low,high);
        updateSegmentTree(segmentTree,index,value,low,mid,2*pos + 1);
        updateSegmentTree(segmentTree,index,value,mid+1,high,2*pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
    }

    private int getMid(int low,int high){
        return (low +(high-low)/2);
    }

    private boolean isTotallyOverlapped(int low, int high, int qLow, int qHigh) {
        return (qLow <= low && high <= qHigh);
    }

    private boolean isNoOverlapping(int low, int high, int qLow, int qHigh) {
        return (qHigh < low || high < qLow);
    }


}
