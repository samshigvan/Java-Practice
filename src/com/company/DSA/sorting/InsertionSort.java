package com.company.DSA.sorting;

import java.util.Arrays;

public class InsertionSort {

    private static int[] sort(int[] num) {

        int size = num.length;
        int count =0;

        for (int i = 0; i < size; i++) {

            int key = num[i];
            int j = i-1;
            while (j>0 && key>num[j]){
                num[j+1] = num[j];
                j--;
                count++;
            }
            num[j+1] = key;
        }
        System.out.println(" Iterations:"+ count);
        return num;
    }

    public static void main(String[] args) {
        int num[] = {64, 34, 25, 12, 22, 11, 90};
        Arrays.stream(sort(num)).forEach(System.out::println);
    }
}
