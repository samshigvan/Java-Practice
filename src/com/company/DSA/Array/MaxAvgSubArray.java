package com.company.DSA.Array;

import static java.lang.System.out;

public class MaxAvgSubArray {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int right =0; right<k; right++ ){
            sum = sum + nums[right];
        }
        int maxSum = sum;

        for(int right =k; right<nums.length; right++ ){

            sum = sum + nums[right] - nums[right-k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double)maxSum/k;
    }
    public static void main(String[] args) {
        int[] nums ={1,12,-5,-6,50,3};
        int k = 4;
        out.println(findMaxAverage(nums, k));
    }
}
