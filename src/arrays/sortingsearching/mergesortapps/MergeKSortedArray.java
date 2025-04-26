package arrays.sortingsearching.mergesortapps;

import linkedlist.ListNode;

import java.util.*;

import static matrix.MatrixRotation.printMatrix;

/*
* https://leetcode.com/problems/merge-k-sorted-lists/
* */
public class MergeKSortedArray {

    public static void main(String[] args) {

        int [][] mat = {{2,6,12,34},
                {1,9,20,1000},
                {23,34,90,2000},
                {15,20,30,40}};
        printMatrix(mat);
       /* int [] newSortedArr = sortKArrayBruteForce(mat,mat.length,mat[0].length);
        System.out.println("sorted array : "+Arrays.toString(newSortedArr));*/

        int [] newSortedArr = kWayMergeSort(mat,mat.length);
        System.out.println("sorted array using kway merging approach : "+Arrays.toString(newSortedArr));


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2)
                -> node1.data - node2.data);

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode smallestNode;

        ListNode dummyNode = new ListNode();
        ListNode currentNode = dummyNode;

        while(!pq.isEmpty()){
            smallestNode = pq.poll();
            if(smallestNode.next != null){
                pq.add(smallestNode.next);
            }
            currentNode.next = smallestNode;
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }

    public static int [] sortKArrayBruteForce(int [][] mat,int k,int n){
        int [] newArr = new int[n*k];
        int newIndex = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                newArr[newIndex++] = mat[i][j];
            }
        }
        Arrays.sort(newArr);
        return newArr;
    }


    public static int [] kWayMergeSort(int [][] mat,int k){
        List<Integer> result = new ArrayList<>(); // mat[0].length*k
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((first,second)->first.data-second.data);
        for (int row=0;row<mat.length;row++){ // k times
            minHeap.add(new HeapNode(mat[row][0],row,0,mat[row].length-1));
        }

        while (!minHeap.isEmpty()){
            HeapNode topNode = minHeap.poll();
            result.add(topNode.data);
            if(topNode.hasNextIndex()){
                // insert next value of same node
                minHeap.add(new HeapNode(mat[topNode.row][topNode.startIndex+1],topNode.row,
                        topNode.startIndex+1,topNode.endIndex));
            }
        }
        return result.stream().mapToInt(data->data).toArray();
    }

    public static class HeapNode{
        int data;
        int row;
        int startIndex;
        int endIndex;
        public HeapNode(int data, int row, int startIndex, int endIndex){
            this.data = data;
            this.row = row;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public boolean hasNextIndex(){
            return this.startIndex < this.endIndex;
        }
    }

   /* public static int [] tournamentMerge(int [][] mat,int k,int n){

        while (k != 0){

            for(int i=1;i<=k;i+=2){

            }
        }
    }*/

    public static int [] mergeTwoArr(int [] arr1,int [] arr2){
        int [] newArray = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                newArray[k++] = arr1[i];
                i++;
                newArray[k++] = arr2[j];
                j++;
            } else if(arr1[i] < arr2[j]){
                newArray[k++] = arr1[i];
                i++;
            }else {
                newArray[k++] = arr2[j];
                j++;
            }
        }
        return newArray;
    }
}
