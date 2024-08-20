package com.company.DSA.hashmap;

import java.util.HashSet;

//https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
public class HappyNumber {

    public static boolean isHappy2(int n){

        int slow =n;
        int fast =n;

        do{
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }while (slow!=fast);

        return fast==1;
    }

    public static int squareSum(int num){

        int reminder=0;
        int ans=0;

        while (num>0){
            reminder = num % 10;
            ans += reminder*reminder;
            num = num/10;
        }
        return ans;
    }

    //Using hashSet
    public static boolean isHappy(int n){

        HashSet<Integer> seen = new HashSet<>();
        int num =n;
        int sum =0;
        int reminder =0;
        while (num!=1){
            if (seen.contains(num)){
                return false;
            }

            seen.add(num);
            while (num>0){
                reminder = num%10;
                sum = sum + reminder*reminder;
                num = num/10;
            }
            num = sum;
            sum =0;
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 19;
        System.out.println(isHappy(n));
    }
}
