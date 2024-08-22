package com.company.DSA.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        int start =0;
        List<String> list = new ArrayList<>();

        for (int end = 1; end <= nums.length; end++) {
            if (end== nums.length || nums[end] != nums[end-1]+1){

                if (start == end-1){
                    list.add(nums[start]+"");
                }else {
                    list.add(nums[start] + "->" + nums[end-1]);
                }
                start =end;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int []nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums).toString());
    }
}
