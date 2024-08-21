package com.company.DSA.other;
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class FirstOccurrenceInString {

    public static int strStr(String haystack, String needle) {

        int hlen = haystack.length();
        int nlen = needle.length();

        if (hlen<nlen)
            return -1;

        for (int i = 0; i <= hlen - nlen; i++) {
            if (haystack.substring(i, i + nlen).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {

        int j = 0;
        int hlen = haystack.length();
        int nlen = needle.length();

        if (hlen <= nlen){
            return haystack.equals(needle) ? 0 : -1;
        }

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(j)){
                while (j<needle.length() ){
                    if (i+j>=hlen || haystack.charAt(i+j) != needle.charAt(j)){
                        j=0;
                        break;
                    }
                    j++;
                }
                if (j>0){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        String haystack ="mississippi";
//        String needle= "issipi";

        String haystack ="bcda";
        String needle= "a";
        System.out.println(strStr(haystack, needle));
    }
}
