package com.company.DSA.hashmap;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        char []a = new char[26];

        if(s.length()!=t.length()){
            return false;
        }

        for(char ch : t.toCharArray()){
            a[ch - 'a']++;
        }

        for(char ch : s.toCharArray()){
            if(a[ch - 'a'] == 0)
                return false;
            a[ch - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "anagram";
        String t= "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
