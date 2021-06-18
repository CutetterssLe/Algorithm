package com.xing.leetcode.basic;

import com.xing.leetcode.basic.node.ListNode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Mystery
 */
public class DesignAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 2, 7, 6, 3};
//        System.out.println(Arrays.toString(shuffle(arr)));
        System.out.println(countPrimes(5));
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

    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnzlu6/
     * @param n
     * @return
     */
    private static int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            for (int j = i; j < n; j+=i) {
                notPrimes[j] = true;
            }
        }
        return count;
    }
}
