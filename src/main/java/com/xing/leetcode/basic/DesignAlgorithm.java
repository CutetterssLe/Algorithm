package com.xing.leetcode.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mystery
 */
public class DesignAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 4, 5, 7, 3};
//        System.out.println(Arrays.toString(shuffle(arr)));
//        System.out.println(countPrimes(5));
//        System.out.println(isPowerOfThree(2));
//        System.out.println(romeNumConvertInt("MCMXCIV"));
//        System.out.println(hammingDistance(1,4));
//        System.out.println(reverseBits(01));
//        System.out.println(isValid("(({{}}))"));
//        System.out.println(generate(5));
        System.out.println(missingNumber(arr));
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

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn1m0i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    private static int hammingWeight(int n) {
        int count = 0;
        //右移，当数字为0时就表示没有'1'了，不需要再比较了
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * x和y都转化为二进制的时候，在相同的位置上如果值都一样，他们的汉明距离就是0。如果在相同的位置上值不一样，
     * 有多少个不一样的位置，那么汉明距离就是多少。所以看到这道题，我们应该最容易想到的就是先异或运算，然后再计算这个异或运算的结果在二进制表示中1的个数。
     *
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnyode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @param y
     * @return
     */
    private static int hammingDistance(int x, int y) {
        int i = x ^ y;
//        Integer.bitCount(i);
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnc5vg/
     * @param n
     * @return
     */
    private static int reverseBits(int n) {
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            res <<= 1;
//            res |= n & 1;
//            n >>= 1;
//        }
        int res = 0;
        //把低16位移到高16上
        for (int i = 0; i < 16; i++) {
            res |= (n & (1 << i)) << (31 - i * 2);
        }
        //把高16位移到低16位上
        for (int i = 16; i < 32; i++) {
            res |= (n & (1 << i)) >>> (i * 2 - 31);
        }

        return res;
    }

    /**
     *给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    private static boolean isValid(String s) {
        int count = s.length() / 2 ;
        for (int i = 0; i < count; i++) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[]", "");
            s = s.replaceAll("\\{}", "");
        }
        return s.equals("");
    }

    /**
     * 杨辉三角
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * @param nums
     * @return
     */
    private static List<List<Integer>> generate(int nums) {
        //结果
        List<List<Integer>> res = new ArrayList<>();
        //每一行的元素
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < nums; i++) {
            //每行第一个肯定是1
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                //后面的数字为左上方和右上方的数的和
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * a ^ a = 0; 0 ^ b = b; 所以 a ^ b ^ a = a ^ a ^ b = b
     *
     * 等差数列，0 ~ n 的和 减去 当前数组内所有数字的和，就是缺失的数字
     * @return
     */
    private static int missingNumber(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int reduce = 0;
        for (int i = 0; i < nums.length; i++) {
            reduce = reduce ^ nums[i] ^ i;
        }
        return reduce ^ nums.length;
    }
}
