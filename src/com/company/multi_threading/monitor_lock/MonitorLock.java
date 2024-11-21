package com.company.multi_threading.monitor_lock;

public class MonitorLock {

    public static void main(String[] args) {

        MonitorLockExample obj = new MonitorLockExample();

        Thread t1 = new Thread(obj::task1);
        Thread t2 = new Thread(obj::task2);
        Thread t3 = new Thread(obj::task3);

        t1.start();
        t2.start();
        t3.start();

        /*
        * Unsynchronized code will not check for lock, it will get run explicitly.
        * Synchronized code will put monitor lock so that only one thread can use that object at a time.
        *
        * */
    }
}

class MonitorLockExample {
    public synchronized void task1(){

        try {
            System.out.println("Synchronized Task 1 before sleep");
            Thread.sleep(10000);
            System.out.println("Synchronized Task 1 after sleep");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){

        System.out.println("Task 2 before synchronized block...");
        synchronized (this){
            System.out.println("Task 2 inside synchronized block...");
        }
    }

    public void task3(){
        System.out.println("Unsynchronized Task 3");
    }
}