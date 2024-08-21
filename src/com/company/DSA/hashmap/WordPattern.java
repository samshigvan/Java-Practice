package com.company.DSA.hashmap;

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        String arr[] = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!=pattern.length()){
            return false;
        }
        int i =0;
        for( char ch : pattern.toCharArray()){

            if(!map.containsKey(ch)){
                if(map.containsValue(arr[i]))
                    return false;
                map.put(ch, arr[i]);
            }else if (!map.get(ch).equals(arr[i])){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern= "abba";
        String s= "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
