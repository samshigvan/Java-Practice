package com.company.DSA.sorting;

import java.util.Arrays;

public class BubbleSort {

    private static int[] bubbleSort(int[] num){

        int n = num.length;
        boolean swapped = false;
        int temp;
        int count =0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {

                if (num[j]>num[j+1]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    swapped =true;
                }
                count++;
            }
            if (!swapped){
                break;
            }
        }
        System.out.println("Number of iteration of inner loop: "+ count);
        return num;
    }

    private static int[] sort(int[] num){

        int n = num.length;

        // to check number of iteration
        int count =0;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i+1; j < n - 1; j++) {
                if (num[i]>num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
                count++;
            }
        }
        System.out.println("Number of iteration of inner loop: "+ count);
        return num;
    }

    public static void main(String[] args) {
        int num[] = {64, 34, 25, 12, 22, 11, 90};
        Arrays.stream(sort(num)).forEach(System.out::println);
    }
}
