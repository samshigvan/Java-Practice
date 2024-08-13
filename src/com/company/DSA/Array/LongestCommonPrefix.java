package com.company.DSA.Array;

import java.util.Arrays;

import static java.lang.System.out;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);
        String lastString = strs[strs.length-1];
        int len = Math.min(strs[0].length(), lastString.length());
        for( int i = 0; i<len; i++){
            if(strs[0].charAt(i) != lastString.charAt(i)){
                return prefix.toString();
            } else {
                prefix.append(lastString.charAt(i));
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        out.println(longestCommonPrefix(strs));
    }
}
