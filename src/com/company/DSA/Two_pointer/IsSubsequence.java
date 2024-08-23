package com.company.DSA.Two_pointer;
//https://leetcode.com/problems/is-subsequence/description/
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
            return true;

        if(s.length()>t.length())
            return false;

        for(int i =0 ; i<s.length(); i++){

            int index = t.indexOf(s.charAt(i));

            if(index==-1)
                return false;

            t = t.substring(index+1);
        }
        return true;
    }

    public static boolean isSubsequence2(String s, String t) {

        if(s.isEmpty())
            return true;

        int start =0;
        for(int end =0; end<t.length() && start<s.length(); end++){

            if(s.charAt(start) == t.charAt(end)){
                if(start == s.length()-1)
                    return true;
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
