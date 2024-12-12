package com.company.DSA.Array;

//Prefix sum works if all elements are greater than 0
public class RangeSumQueryImmutable {

    public static void main(String[] args) {

        int [] nums= {1,4,-6};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
    }
}
class NumArray {

    int[] nums;
    public NumArray(int[] nums) {

        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        int sum=0;
        for (int i=left; i<= right; i++){
            sum += nums[i];
        }
        return sum;
    }
}
