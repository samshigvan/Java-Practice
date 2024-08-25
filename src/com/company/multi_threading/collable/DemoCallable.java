package com.company.multi_threading.collable;

import java.util.concurrent.Callable;

public class DemoCallable implements Callable<Integer> {

    long milis;
    int a;
    int b;

    public DemoCallable(long milis, int a, int b) {
        this.milis= milis;
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " sleep started");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " sleep ended");
        return a + b;
    }
}
