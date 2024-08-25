package com.company.multi_threading.producer_consumer.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvalaible = false;

    public void producer(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by "+ Thread.currentThread().getName());
            isAvalaible = true;
            Thread.sleep(3000);
        } catch (InterruptedException ignored){

        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by "+ Thread.currentThread().getName());
            isAvalaible = true;
            Thread.sleep(3000);
        } catch (InterruptedException ignored){

        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by "+ Thread.currentThread().getName());
        }
    }
}
