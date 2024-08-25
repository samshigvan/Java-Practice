package com.company.multi_threading;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{

            for (int i = 0; i < 5; i++) {

                try {
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        thread.join();
        System.out.println("Main thread reached to end..");
    }
}
