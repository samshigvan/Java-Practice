package com.company.DSA.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
