package com.company.DSA.other;

import java.util.HashMap;

import static java.lang.System.*;

public class RomanToNumber {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map= new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum =0;
        int len = s.length();
        for(int i=0; i<len; i++){

            if(i < len){
                if(i<len-1 && map.get(s.charAt(i))< map.get(s.charAt(i+1)))
                    sum = sum - map.get(s.charAt(i));
                else
                    sum = sum + map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String roman = "LVIII"; //LVIII MCMXCIV
        out.println(romanToInt(roman));
    }
}
