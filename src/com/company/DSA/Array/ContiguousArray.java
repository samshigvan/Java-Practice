package com.company.DSA.Array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {

        int maxlen = 0,count =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1? 1:-1;

            if (map.containsKey(count))
                maxlen = Math.max(maxlen, i-map.get(count));
            else
                map.put(count, i);
        }
        return maxlen;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0};

        System.out.println(findMaxLength(nums));
    }
}
