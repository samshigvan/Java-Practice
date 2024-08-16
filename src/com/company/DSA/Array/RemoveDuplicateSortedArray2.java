package com.company.DSA.Array;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.out;

public class RemoveDuplicateSortedArray2 {

    public static int removeDuplicates(int[] nums) {

        int cnt=nums.length;
        if (cnt<=2){
            return cnt;
        }
        int start=2;

        for (int end=2; end< nums.length; end++){
            if (nums[end]!=nums[start-2]){
                nums[start] =nums[end];
                start++;
            }
        }
        Arrays.stream(nums).forEach(out::println);
        return start;
    }

    public static int removeDuplicates2(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt =0;

        for(int i = 0 ; i < nums.length; i ++){

            if(!map.containsKey(nums[i]) ){
                map.put(nums[i],1);
            } else {
                if (map.put(nums[i], map.get(nums[i]) +1 )>=2){
                    nums[i] = (int) Math.pow(10,4);
                    cnt++;
                }
            }
        }
        Arrays.sort(nums);
        for(int i = nums.length-cnt ; i < nums.length; i ++){

            nums[i] = '_';
        }
        out.println();
        Arrays.stream(nums).forEach(System.out::println);
        return nums.length-cnt;
    }

    public static void main(String[] args) {
//        int[] arr = {-1,0,0,0,0,3,3};

        int[] arr = {1,1,1,2,2,3};
        out.println(removeDuplicates(arr));
    }
}
