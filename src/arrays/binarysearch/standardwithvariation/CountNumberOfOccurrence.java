package arrays.binarysearch.standardwithvariation;

public class CountNumberOfOccurrence {

    public static void main(String[] args) {

        int [][] matrix = {{2,2,2,2,2,2,2},
                {1,3,4,5,6,9,10},
                {1,3,4,5,6,9,10},
                {1,3,4,5,5,5,6,6,6,6,7},
                {1,3,4,5,5,5,5,6,6,6,6,7},
                {1,3,4,5,5,5,5,6,6,6,6,7},
                {-5,-4,-4,-4,4,6,8,9},
                {1, 3, 5, 5, 5, 5, 67, 123, 125}
        };
        int [] targets = {2,6,2,5,6,7,-4,5};
        int [] expectedArr = {7,1,-1,3,4,1,3,4};
        int [] result = new int[targets.length];
        CountNumberOfOccurrence countNumberOfOccurrence = new CountNumberOfOccurrence();
        for(int i=0;i<result.length;i++){
            result[i] = countNumberOfOccurrence.countNumberOfOccurrenceOfElement(matrix[i],0,matrix[i].length-1,targets[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i]);
            }else {
                System.out.println("result is as expected for index matrix "+ i);
            }
        }
    }

    public int countNumberOfOccurrenceOfElement(int [] arr,int low,int high,int target){
        FirstOccurrenceInArray firstOccurrenceInArray = new FirstOccurrenceInArray();
        LastOccurrenceInArray lastOccurrenceInArray = new LastOccurrenceInArray();
        int indexOfFirstOcc = firstOccurrenceInArray.findFirstOccurrenceOfElement(arr,low,high,target);
        if(indexOfFirstOcc == -1){
            return -1;
        }
        int indexOfLastOcc = lastOccurrenceInArray.lastFirstOccurrenceOfElement(arr,low,high,target);
        return (indexOfLastOcc - indexOfFirstOcc)+1;
    }

}
