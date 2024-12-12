package com.company.DSA.Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k){

        int presum =0;
        int count =0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];

            if (map.containsKey(presum-k)){
                count += map.get(presum-k);
            }

            map.put(presum, map.getOrDefault(presum,0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k =2;

        System.out.println( subarraySum(nums, k));
    }
}
