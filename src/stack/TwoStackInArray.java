package stack;

public class TwoStackInArray {
    private static int [] arr;
    private static int sIndex;
    private static int lIndex;

    public TwoStackInArray(int n){
        this.arr = new int[n];
    }

    public static void main(String[] args) {
        int n = 10;
        TwoStackInArray stObj = new TwoStackInArray(10);
        sIndex = -1;
        lIndex = arr.length;

        if(stObj.pop1() == -1){
            System.out.println("Stack 1 is empty ");
        }
        stObj.push1(10);
        stObj.push1(20);
        if(stObj.pop2() == -1){
            System.out.println("st2 is empty");
        }
        System.out.println("stack 1's top element "+stObj.pop1());
        stObj.push2(50);
        stObj.push2(60);
        stObj.push2(10);
        stObj.push2(20);
        stObj.push2(30);
        stObj.push2(40);
        stObj.push2(50);
        stObj.push2(60);
        stObj.push2(70);
        stObj.push2(80);
        stObj.push2(90);
        System.out.println("stack 2's top element "+stObj.pop2());

    }

    public boolean push1(int val){
        if((sIndex == arr.length -1) || (sIndex+1 >= lIndex)){
            System.out.println("stack 1 is full stack");
            return false;
        }
        System.out.println("element to be insert in st1 ..."+val);
        arr[++sIndex] = val;
        return true;
    }

    public boolean push2(int val){
        if((lIndex == 0) || (lIndex-1 <= sIndex)){
            System.out.println("stack 2 is full stack");
            return false;
        }
        System.out.println("element to be insert in st2 ..."+val);
        arr[--lIndex] = val;
        return true;
    }

    public int pop1(){
        if(sIndex == -1){
            return -1;
        }
        int temp =  arr[sIndex];
        sIndex--;
        return temp;
    }

    public int pop2(){
        if(lIndex == arr.length){
            return -1;
        }
        int temp =  arr[lIndex];
        lIndex++;
        return temp;
    }

}
