package com.company.DSA.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static int[] sort(int[] num) {

        for (int i = 0; i < num.length; i++) {

            int min_index = i;

            for (int j = i+1; j < num.length; j++) {
                if (num[min_index]>num[j])
                    min_index = j;
            }

            int temp = num[min_index];
            num[min_index] = num[i];
            num[i] = temp;
        }

        return num;
    }

    public static void main(String[] args) {
        int num[] = {64, 34, 25, 12, 22, 11, 90};
        Arrays.stream(sort(num)).forEach(System.out::println);
    }
}
