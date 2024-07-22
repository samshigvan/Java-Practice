package com.company.multithreding;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

public class MainThread {

        static Thread t1, t2,t3;

    public static void main(String[] args) throws InterruptedException {
        t1 = new ThreadTask();
        t1.setName("T1");

        t2 = new Thread(new RunnableTask());
        t2.setName("T2");

        t3 = new Thread(new RunnableTask());
        t3.setName("T3");

//        runWithJoin();

        // Single thread executor service
//        run(Executors.newSingleThreadExecutor());

        // fixed thread pool, create fix number of thread pools.
        // if number of threads increases adds them into queue until any running thread get complete
//        run(Executors.newFixedThreadPool(2));

        // cached thread pool, create thread pools
        // if number of thread increases than pool size then it creates more threads
        // if any thread remains idle for close to 60secs then its get terminated and removes from cache
//        run(Executors.newCachedThreadPool());

        //When we want to schedule our tasks, like run them on specific interval or with specific time delay
//        run(Executors.newScheduledThreadPool(2));
//        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(3);
//        run(new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, blockingDeque));
    }

    public static void runWithJoin() throws InterruptedException {
        t1.start();
        t1.join();
        t3.start();
        t2.start();
    }

    public static void run(ExecutorService executorService){
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();
    }
}
