package com.company.multi_threading.producer_consumer;

import java.util.Queue;

public class SharedResource {

    private int bufferSize;
    private Queue<Integer> buffer;

    public SharedResource(int bufferSize, Queue<Integer> buffer) {
        this.bufferSize = bufferSize;
        this.buffer = buffer;
    }

    public synchronized void produceItem(Integer n) throws InterruptedException {

        while (buffer.size()>bufferSize){
            System.out.println("Buffer size is full");
            wait();
        }
        buffer.add(n);
        System.out.println("Produced "+ n);
        notify();
    }

    public synchronized void consumeItem() throws InterruptedException {

        while (buffer.isEmpty()){
            wait();
        }
        System.out.println("Consumed "+ buffer.poll());
        notify();
        consumeItem();
    }

    public SharedResource() {
    }
}
