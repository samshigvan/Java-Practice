package com.company.DSA.binary_search;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right =nums.length-1;
        int mid;

        while( left<right){

            mid = left + (right - left) /2;

            if (nums[mid] == target ){
                return mid;
            } else if ( target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(arr, target));
    }
}
