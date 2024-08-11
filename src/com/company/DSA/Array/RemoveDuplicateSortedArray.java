package com.company.DSA.Array;

import static java.lang.System.*;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
public class RemoveDuplicateSortedArray {

    public static int removeDuplicates(int[] nums) {

        int start=1;

        for (int end=1; end< nums.length; end++){

            if (nums[end]!=nums[end-1]){
                nums[start]=nums[end];
                start++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        out.println(removeDuplicates(arr));
    }
}
