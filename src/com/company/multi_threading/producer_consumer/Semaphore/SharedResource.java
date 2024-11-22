package com.company.multi_threading.producer_consumer.Semaphore;

import java.util.concurrent.Semaphore;

/*
* Using Semaphore we can tell how many threads can run that line of code at a time.
* */
public class SharedResource {

    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try {
            lock.acquire();
            System.out.println("Lock acquired by "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        } finally {

            lock.release();
            System.out.println("Lock released by "+ Thread.currentThread().getName());
        }
    }
}
