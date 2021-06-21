package com.xing.leetcode.basic;

import java.util.Random;

/**
 * @author Mystery
 */
public class DesignAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 2, 7, 6, 3};
//        System.out.println(Arrays.toString(shuffle(arr)));
//        System.out.println(countPrimes(5));
        System.out.println();
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

    /**
     * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnsdi2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 题中n的范围是-2^31 <= n <= 2^31 - 1，而在这个范围内3的最大幂是1162261467，
     * 在比他大就超过int表示的范围了，我们直接用它对n求余即可，过求余的结果是0，说明n是3的幂次方
     *
     * @param n
     * @return
     */
    private static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
