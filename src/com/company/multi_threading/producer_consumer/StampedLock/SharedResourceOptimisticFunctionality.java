package com.company.multi_threading.producer_consumer.StampedLock;

import java.util.concurrent.locks.StampedLock;

/*
    Stamped lock supports both read-write lock & optimistic lock functionality.

    Here is example of optimistic lock functionality..
 */
public class SharedResourceOptimisticFunctionality {

    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer(){

        long stamp = lock.tryOptimisticRead();

        try {

            System.out.println("Optimistic lock by "+ Thread.currentThread().getName());
            a =11;
            Thread.sleep(6000);

            if (lock.validate(stamp)){
                System.out.println("Updated successfully by "+ Thread.currentThread().getName());
            } else {
                System.out.println("Rollback of work...");
                a=10; //rollback
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void consume(){

        long stamp = lock.tryWriteLock();
        System.out.println( "Write lock acquired by "+ Thread.currentThread().getName());

        try {
            System.out.println("Performing work by "+ Thread.currentThread().getName());
            a = 9;
        } finally {
            lock.unlockWrite(stamp);
            System.out.println( "Write lock released by "+ Thread.currentThread().getName());
        }
    }
}
