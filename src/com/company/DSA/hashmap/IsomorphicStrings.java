package com.company.DSA.hashmap;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){

            if(map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else{
                if (map.containsValue(t.charAt(i)) ) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "egg";
        String magazine = "add";
        System.out.println(isIsomorphic(ransomNote, magazine));
    }
}
