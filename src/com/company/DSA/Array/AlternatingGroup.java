package com.company.DSA.Array;

import static java.lang.System.*;

//https://leetcode.com/problems/alternating-groups-i/
public class AlternatingGroup {

    public static int numberOfAlternatingGroups(int[] colors) {

        int len =colors.length;
        int count=0;
        int start=len-1;
        int next;
        for(int end =0; end<len; end++)
        {
            next = end+1 > len-1? len-end-1: end+1;
            if (colors[start]==colors[next] && colors[next] != colors[end]){
                count++;
            }
            if(start>=len-1){
                start=0;
            }else {
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        //010
        //101
        //010
        int[] num = {0,1,0,0,1};
//        int num[] = {0, 1, 0};
        out.println(numberOfAlternatingGroups(num));
    }
}
