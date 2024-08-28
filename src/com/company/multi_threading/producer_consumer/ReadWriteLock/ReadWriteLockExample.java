package com.company.multi_threading.producer_consumer.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    /*
    * When we have very high read operation compared to write operations, ReadWriteLock is useful*/
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(()->{
            resource.producer(lock);
        });

        Thread t2 = new Thread(()->{
            resource.producer(lock);
        });

        Thread t3 = new Thread(()->{
            resource.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
