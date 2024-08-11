package com.company.DSA.Array;

import static java.lang.System.*;

//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        int len = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];

        for(int end =1; end<len; end++){
            sum = Math.max(nums[end], sum + nums[end]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int []arr= {-2,1,-3,4,-1,2,1,-5,4};
        out.println(maxSubArray(arr));
    }

}
