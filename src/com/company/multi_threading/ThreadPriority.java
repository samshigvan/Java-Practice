package com.company.multi_threading;

public class ThreadPriority {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{

            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException ex){

            }
        });

        Thread t2 = new Thread(()->{

            try {
                for (int i = 'a'; i < 'e'; i++) {
                    System.out.println((char) i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException ex){

            }
        });

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

        System.out.println("priority doesn't guarantees the order of task execution,");
        System.out.println("it is just to hint task scheduler what to execute next..");
        System.out.println("Main thread reached to end..");
    }
}
