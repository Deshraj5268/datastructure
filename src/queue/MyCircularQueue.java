package queue;


/*
* http://algorithmsforgeeks.blogspot.com/2017/03/create-queue-using-array.html
* */
public class MyCircularQueue {

    int [] arr;
    int f;
    int r;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.size = k;
        this.f = 0;
        this.r = -1;
        this.capacity = 0;
    }

    public static void main(String[] args) {

        int k=3;
        MyCircularQueue circularQueue = new MyCircularQueue(k);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        System.out.println(circularQueue.rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        circularQueue.enQueue(4);
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.rear());
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        r = (r+1)%size;
        arr[r] = value;
        capacity += 1;
        return true;

    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        int temp = arr[f];
        f = (f+1)%size;
        capacity -= 1;
        return true;
    }

    public int front() {
        return isEmpty()?-1:arr[f];
    }

    public int rear() {
        return isEmpty()?-1:arr[r];
    }

    public boolean isEmpty() {
        return (capacity == 0);

    }

    public boolean isFull() {
        return (capacity == size);
    }
}
