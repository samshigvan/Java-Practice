package com.company.multi_threading.producer_consumer.StampedLock;

import java.util.concurrent.locks.StampedLock;

/*
    Stamped lock supports both read-write lock & optimistic lock functionality.

    Here is example of read-write lock functionality..
 */
public class SharedResourceReadWriteFunctionality {

    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer(){

        long stamp = lock.readLock();

        try {
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());

            isAvailable = true;
            Thread.sleep(6000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read lock released by " + Thread.currentThread().getName());
        }
    }

    public void consume(){

        long stamp = lock.writeLock();

        try {
            System.out.println("Write lock acquired by "+ Thread.currentThread().getName());

            isAvailable = false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            lock.unlockWrite(stamp);
            System.out.println("Write lock released by "+ Thread.currentThread().getName());
        }
    }
}
