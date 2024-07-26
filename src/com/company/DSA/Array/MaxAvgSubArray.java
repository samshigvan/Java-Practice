package com.company.DSA.Array;

public class MaxAvgSubArray {

    public static double findMaxAverage(int[] nums, int k) {
        int windowStart=0;
        int len=nums.length;
        int windowSum =0;
        double windowAvg = 0;
        double maxAvg =0;

        for(int windowEnd=0; windowEnd<=len-1; windowEnd++){
            windowSum = nums[windowEnd]+ windowSum ;

            if(windowEnd>=k-1){
                windowAvg = (double) windowSum /k;
                maxAvg = Math.max(maxAvg, windowAvg);
                windowSum = windowSum-nums[windowStart];
                windowStart = windowStart+1;
            }
        }
        return maxAvg;
    }
    public static void main(String[] args) {
        int nums[] ={1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
