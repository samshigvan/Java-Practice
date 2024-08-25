package com.company.multi_threading.producer_consumer.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {

        SharedResource1 obj1 = new SharedResource1();

        Thread t1 = new Thread(obj1::producer);

        SharedResource1 obj2 = new SharedResource1();
        Thread t2 = new Thread(()-> obj2.producer());

        t1.start();
        t2.start();
    }
}

