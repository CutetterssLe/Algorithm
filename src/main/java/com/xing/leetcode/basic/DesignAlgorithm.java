package com.xing.leetcode.basic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Mystery
 */
public class DesignAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 2, 7, 6, 3};
        System.out.println(Arrays.toString(shuffle(arr)));
    }

    /**
     * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
     * @param nums
     * @return
     */
    private static int[] shuffle(int[] nums) {
        if (nums == null) {
            return null;
        }
        Random random = new Random();
        int[] temp = nums.clone();
        for (int i = 1; i < temp.length; i++) {
            int j = random.nextInt(i + 1);
            swap(temp, j, i);
        }
        return temp;
    }

    private static void swap(int[] nums, int j, int i) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }

    }
}
