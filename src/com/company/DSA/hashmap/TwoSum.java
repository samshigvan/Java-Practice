package com.company.DSA.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];
            if (map.containsKey(complement) && i != map.get(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums= {2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(e-> System.out.print(e + ", "));
    }
}
