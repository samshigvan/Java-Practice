package com.company.DSA.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChar {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int start =0;
        int maxLen = 0;

        for (int end =0; end<s.length(); end++){

            if (map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end)) +1, start);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {

        HashSet<Character> set = new HashSet<Character>();
        int start =0;
        int maxLen = 0;

        for (int end =0; end<s.length(); end++){

            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                maxLen = Math.max(maxLen, end-start+1);
            }else {

                while (set.contains(s.charAt(end))){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s= "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
