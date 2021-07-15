package com.xing.leetcode.middle;

import java.util.List;

/**
 * @author Mystery
 */
public class StringAndArrayAlgorithm {
    public static void main(String[] args) {
        String s = "12312.p.jpg";
        s = s.substring(s.lastIndexOf(".") + 1);
        System.out.println(s);
    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvpj16/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}