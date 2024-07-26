package com.company.DSA.Array;

public class MinSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        int start =0;
        int sum=0;
        int len=nums.length;
        int minLen= Integer.MAX_VALUE;
        int minSum=0;

        for(int end =0; end<len; end++){
            sum += nums[end];

            while(sum>=target){
                minLen = Math.min(minLen, end-start);
                sum = sum-nums[start];
                start = start +1;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return 0;
        return minLen+1;
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        int nums[] ={2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
