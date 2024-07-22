package com.company.multithreding;

public class RunnableTask implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " sleeping for 4sec");
            Thread.sleep(4000);
            System.out.println("Runnable task: "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
