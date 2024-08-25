package com.company.multi_threading;

public class ThreadTask extends Thread{

    @Override
    public void run() {
        super.run();

        try {
            System.out.println(Thread.currentThread().getName() + " sleeping for 4sec");
            Thread.sleep(4000);
            System.out.println("Thread task: "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
