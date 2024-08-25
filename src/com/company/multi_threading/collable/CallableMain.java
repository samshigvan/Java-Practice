package com.company.multi_threading.collable;

import java.util.concurrent.*;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        FutureTask[] tasks = new FutureTask[5];
//
//        for (int i=0; i< tasks.length; i++){
//            tasks[i] = new FutureTask(new DemoCallable());
//            Thread t = new Thread(tasks[i]);
//            t.setName("Task "+ i);
//            t.start();
//        }
//
//        for (int i = 0; i < tasks.length; i++) {
//            System.out.println(tasks[i].get());
//        }

//        int i = 10;
//        FutureTask task = new FutureTask(()->{  Thread.sleep(5000);return i;});
//        Thread thread = new Thread(task);
//        thread.start();
//        System.out.println(task.get());

        // this will run service one by one, because get method pause the current thread execution till we get future object
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Integer sum1 = executorService.submit(new DemoCallable(5000, 10, 20)).get();
        Integer sum2 = executorService.submit(new DemoCallable(5000, 20, 30)).get();
        System.out.println("sum1 =" + sum1);
        System.out.println("sum2 =" + sum2);
        executorService.shutdown();

        // it will run both tasks parallely
        ExecutorService executorService2 = Executors.newScheduledThreadPool(2);
        Future<Integer> sum3 = executorService2.submit(new DemoCallable(5000, 10, 20));
        Future<Integer> sum4 = executorService2.submit(new DemoCallable(5000, 20, 30));
//        timeout in future get method- it will wait for giving time, if we get future object in that time it will accept it else throws timeout exception
//        sum3.get(3,TimeUnit.SECONDS);
        System.out.println("sum1 =" + sum3.get());
        System.out.println("sum2 =" + sum4.get());
        executorService2.shutdown();
    }
}
