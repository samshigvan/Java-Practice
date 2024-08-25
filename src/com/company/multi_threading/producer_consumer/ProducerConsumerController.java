package com.company.multi_threading.producer_consumer;

import java.util.LinkedList;

public class ProducerConsumerController {


    public static void main(String[] args) throws InterruptedException {
        SharedResource obj = new SharedResource(3, new LinkedList<>());

        Thread producer = new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    obj.produceItem(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            try {
                obj.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
