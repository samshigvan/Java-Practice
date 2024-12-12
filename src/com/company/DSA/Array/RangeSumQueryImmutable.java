package com.company.DSA.Array;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {

        int [] nums= {1,4,-6};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
    }
}
class NumArray {

    private final int[] preffixSum,nums;
    public NumArray(int[] nums) {

        this.nums = nums;
        this.preffixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            preffixSum[i] = nums[i];

            if (i>0) {
                preffixSum[i] = preffixSum[i] + preffixSum[i-1];
            }
        }
    }

    public int sumRange(int left, int right) {

        return left == 0 ? preffixSum[right] : preffixSum[right] - preffixSum[left - 1];

    }
}
