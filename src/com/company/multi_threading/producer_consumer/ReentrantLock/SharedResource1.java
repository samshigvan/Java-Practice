package com.company.multi_threading.producer_consumer.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource1{

    boolean isAvailable =false;
    // its must be static then only it will get shared by all objects
    static ReentrantLock lock = new ReentrantLock();

    public void producer(){
        try{
            lock.lock();
            System.out.println("lock acquired by "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch (Exception ex){

        }finally {
            lock.unlock();
            System.out.println("lock released by "+ Thread.currentThread().getName());
        }
    }
}
