package com.company.multi_threading;

public class ThreadCreation {

    public static void main(String[] args) {
        // 1. By extending Thread class
        Thread task1 = new Task1();
        task1.setName("Task-1-Created-by-extending-Thread-class");
        task1.start();

        // 2. By implementing runnable interface
        Thread task2 = new Thread(new Task2());
        task2.setName("Task-2-Created-by-implementing-runnable-interface");
        task2.start();
    }
}

class Task1 extends Thread{

    public void run(){
        System.out.println("Current running thread:"+Thread.currentThread().getName());
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Current running thread:"+Thread.currentThread().getName());
    }
}
