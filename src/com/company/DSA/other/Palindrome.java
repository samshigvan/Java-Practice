package com.company.DSA.other;

import static java.lang.System.*;

public class Palindrome {

    private static boolean isPolindrome(int n){

        if (n<0)
            return false;

        int sum = 0;
        int temp;
        int ref =n;

        while (n>0){
            temp= n%10;
            sum = (sum*10)+ temp;
            n=n/10;
        }
        return ref == sum;
    }

    public static void main(String[] args) {
        int n = 4545;
        out.println(isPolindrome(n));
    }
}
