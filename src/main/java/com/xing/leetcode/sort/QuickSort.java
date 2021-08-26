package com.xing.leetcode.sort;

import java.util.Arrays;

/**
 * @author Mystery
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 9, 1, 8};
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //设定基准值
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
