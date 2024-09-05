package com.company.DSA.sorting;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] num, int start, int mid, int end) {

        int n1 = mid-start +1;
        int n2 = end-mid;

        int[] num1 = new int[n1];
        int[] num2 = new int[n2];

        for (int i = 0; i < n1; ++i)
            num1[i] = num[start + i];
        for (int j = 0; j < n2; ++j)
            num2[j] = num[mid + 1 + j];

        int i =0, j=0;
        int k = start;

        while (i<n1 && j<n2){
            if (num1[i]<=num2[j]){
                num[k] = num1[i];
                i++;
            } else{
                num[k] = num2[j];
                j++;
            }
            k++;
        }

        while (i<n1){
            num[k] = num1[i];
            i++;
            k++;
        }

        while (j<n2){
            num[k] = num2[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] num, int start, int end){
        if (start<end){
            int mid = start + (end -start)/2;
            sort(num, start , mid);
            sort(num, mid+1 , end);

            merge(num, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int num[] = {64, 34, 25, 12, 22, 11, 90};
        sort(num, 0, num.length-1);
        Arrays.stream(num).forEach(System.out::println);
    }
}
