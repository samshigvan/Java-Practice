package com.company.DSA.other;

import java.util.HashMap;

import static java.lang.System.*;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharInString {

    private static int firstUniqChar(String s){

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i],0)+1);
        }
        for (int i=0; i<chars.length; i++){
            if (map.get(chars[i])==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str= "leetcode";
        out.println(firstUniqChar(str));
    }
}
