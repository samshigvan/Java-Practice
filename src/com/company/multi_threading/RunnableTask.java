package com.company.multi_threading;

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
