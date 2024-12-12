package com.company.DSA.Array;

import java.util.Arrays;

public class TwoSum2SortedArray {

    public static int[] twoSum(int[] numbers, int target) {

        int start =0;
        int end = numbers.length-1;

        while (start<end){

            int sum = numbers[start] + numbers[end];

            if (sum == target)
                break;
            else if (sum<target) {

                start++;
            } else
                end--;
        }

        return new int[]{start+1, end+1};
    }

    public static void main(String[] args) {

        int[] numbers= {2,7,11,15};
        int target = 9;

        Arrays.stream(twoSum(numbers, target)).forEach(System.out::println);
    }
}
