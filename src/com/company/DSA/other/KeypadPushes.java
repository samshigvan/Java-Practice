package com.company.DSA.other;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;
//https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/

public class KeypadPushes {

    public static int minimumPushes2(String word){
        int[] letterFrequency = new int[26];
        for (char c : word.toCharArray()) {
            letterFrequency[c - 'a']++;
        }

        Integer[] sortedFreq = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedFreq[i] = letterFrequency[i];
        }
        Arrays.sort(sortedFreq, Collections.reverseOrder());

        int totalPresses = 0;
        for (int i = 0; i < 26; i++) {
            if (sortedFreq[i] == 0) break;
            totalPresses += (i / 8 + 1) * sortedFreq[i];
        }

        return totalPresses;
    }

    public static int minimumPushes(String word) {

        Map<Character, Integer> keyFreq = new HashMap<>();
        HashMap<Character, Integer> keyPad = new HashMap<>();
        int keyDowns = 1;
        int keyDownsCount = 0;

        for (int i =0; i<word.length(); i++){
            Character c= word.charAt(i);
            keyFreq.put(c, keyFreq.getOrDefault(c,0)+1);
        }

        List<Character> keys = keyFreq.entrySet().stream().sorted((k, v)-> v.getValue().compareTo(k.getValue())).map(k-> k.getKey()).collect(Collectors.toList());

        for (Character c : keys) {
            if (!keyPad.containsKey(c)) {
                if (keyPad.size() >= 24) {
                    keyDowns = 4;
                } else if (keyPad.size() >= 16) {
                    keyDowns = 3;
                } else if (keyPad.size() >= 8) {
                    keyDowns = 2;
                } else {
                    keyDowns = 1;
                }
                keyPad.put(c, keyDowns);
            }
        }
        for (int i =0; i<word.length(); i++){

            Character c = word.charAt(i);
            keyDownsCount = keyDownsCount + keyPad.get(c);
        }
        return keyDownsCount;
    }

    public static void main(String[] args) {
        String s ="aabbccddeeffgghhiiiiii";
        out.println(minimumPushes2(s));
    }
}
