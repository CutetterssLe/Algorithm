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
//        System.out.println(isPowerOfThree(2));
        System.out.println(romeNumConvertInt("MCMXCIV"));
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

    /**
     *罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn4n7c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    private static int romeNumConvertInt(String s) {
        //临时求出的和
        int sum = 0;
        //以第一个为开始，作为前一个数字
        int preNum = getRomeValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            //获取当前数字
            int num = getRomeValue(s.charAt(i));
            //如果前一个数字比当前数字小，说明要相减
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            //每次比较完成后，设置当前数字为前一个数字
            preNum = num;
        }
        //最后加上前一个数字就是结果
        sum += preNum;
        return sum;
    }

    private static int getRomeValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
