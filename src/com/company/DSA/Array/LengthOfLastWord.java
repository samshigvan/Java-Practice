package com.company.DSA.Array;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        s = s.trim();
        int i = s.length()-1;

        while ( i >= 0 ){

            if (s.charAt(i) == ' '){

                return s.length() -i - 1;
            }
            i--;
        }
        return s.length();
    }

    public static int lengthOfLastWord2(String s) {

        int len = 0;
        int i=0;
        int lastSpace =-1;
        s = s.trim();
        while (i<s.length()){

            if (s.charAt(i) == ' ' ){
                len = i - lastSpace -1;
                lastSpace = i;
            }

            if (i == s.length()-1 ){
                len = i - lastSpace;
            }
            i++;
        }

        return len;
    }

    public static void main(String[] args) {

        String s ="aab";
//        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
