package com.company.DSA.Two_pointer;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);

        int len = s.length();
        int i =0;
        while (i<len/2 ){
            if (s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s="A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
