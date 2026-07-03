package javapractice.multithreading;

public class DeadlockExample {

    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Thread-1 acquired LOCK1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (LOCK2) {
                    System.out.println("Thread-1 acquired LOCK2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("Thread-2 acquired LOCK2");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (LOCK1) {
                    System.out.println("Thread-2 acquired LOCK1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

/*
*
* Fix (avoid deadlock)

✔ Always acquire locks in same order

// Both threads follow same order
synchronized (LOCK1) {
    synchronized (LOCK2) {
        // safe
    }
}
* */
