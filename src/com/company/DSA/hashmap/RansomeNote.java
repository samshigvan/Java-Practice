package com.company.DSA.hashmap;

import java.util.HashMap;

public class RansomeNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for (char ch : ransomNote.toCharArray()){
            if (map.containsKey(ch)){
                int count = map.get(ch);
                if (count<= 0){
                    return false;
                }
                map.put(ch, count-1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aabc";
        String magazine = "abdef";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}