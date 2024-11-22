package com.company.multi_threading.producer_consumer.StampedLock;

public class Main {

    public static void main(String[] args) {

//        readWriteFunctionality();

        optimisticFunctionality();
    }

    private static void readWriteFunctionality(){

        SharedResourceReadWriteFunctionality sh = new SharedResourceReadWriteFunctionality();

        Thread t1 = new Thread(sh::producer);

        Thread t2 = new Thread(sh::producer);

        Thread t3 = new Thread(sh::consume);

        t1.start();
        t2.start();
        t3.start();
    }

    private static void optimisticFunctionality(){

        SharedResourceOptimisticFunctionality sh = new SharedResourceOptimisticFunctionality();

        Thread t1 = new Thread(sh::producer);

        Thread t2 = new Thread(sh::consume);

        t1.start();
        t2.start();
    }
}
