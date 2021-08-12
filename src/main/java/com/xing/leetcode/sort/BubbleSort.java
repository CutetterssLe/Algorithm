package com.xing.leetcode.sort;

import java.util.Arrays;

/**
 * @author Mystery
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 9, 1, 8};

        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
