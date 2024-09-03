package com.company.DSA.Array;

public class SumOfDigitsAfterConvert {

    public static int getLucky(String s, int k) {

        StringBuilder number = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            number.append(s.charAt(i)-'a'+1);
        }

        while(k>0){

            int sum =0;
            for(int i=0; i< number.toString().trim().length(); i++){
                sum = sum + number.charAt(i) - '0';
            }
            number = new StringBuilder("" +sum);
            k--;
        }
        return Integer.parseInt(number.toString());
    }

    public static void main(String[] args) {

        String s = "iiii";
        int k = 1;
        System.out.println(getLucky(s, k));
    }
}
