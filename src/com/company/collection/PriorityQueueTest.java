package com.company.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
//        queue.add(20);
//        queue.add(100);
//        queue.add(30);
//        queue.add(50);
//        queue.add(80);
//        queue.add(10);
//        System.out.println(queue);

        int a[] = { 10, 30, 40, 20, 70, 60, 80, 50, 90, 100};
        System.out.println(largestElement(a, 4));
    }

    //fine kth largest element
    public static Integer largestElement(int a[], int k){

        PriorityQueue<Integer> integers = new PriorityQueue<>();

        for (int i =0; i< k; i++){
            integers.add(a[i]);
        }
        for (int i=k; i< a.length; i++){
            if (integers.peek() < a[i]){
                integers.poll();
                integers.add(a[i]);
            }
        }
        return integers.peek();
    }
}
