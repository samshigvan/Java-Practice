package com.company.DSA.Array;

import java.util.Arrays;

public class MergeSortedArray {

//  Time complexity: O((m+n)log(m+n))
//  Space complexity: O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int j=0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        Arrays.stream(nums1).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

//        int[] num1 = {0};
//        int[] num2 = {6};
        merge(num1, 3,  num2, num2.length);
    }
}
