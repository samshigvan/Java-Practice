package com.company.DSA.Two_pointer;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {

    public static boolean isPalindrome(String s){

        int start =0;
        int end = s.length()-1;

        while (start<end){
            int left = isValidChar(s.charAt(start));
            int right = isValidChar(s.charAt(end));

            if (left == -1)
                start++;
            else if (right == -1)
                end--;
            else if (left != right)
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
    public static int isValidChar(char c){

        if( c >= '0' && c<='9')
            return c;
        else if (c>='a' && c<= 'z') {
            return c;
        } else if (c >= 'A' && c<= 'Z') {
            return c - 'A' + 'a';
        }
        return -1;
    }

    public static boolean isPalindrome2(String s) {

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
        String s="A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = "0a";
        System.out.println(isPalindrome(s));
    }
}
