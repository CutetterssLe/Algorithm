package com.xing.leetcode.middle;

import java.util.*;


/**
 * @author Mystery
 */
public class StringAndArrayAlgorithm {
    public static void main(String[] args) throws Exception {
        int[] nums = {-1, -1, 0, -4, -4, 1, -2, 2, 0, -4};
//        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
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
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        //排序之后方便比较
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //这里是因为前面的i已经比过了，在比一次没意义
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针
            int f = i + 1;
            int l = nums.length - 1;
            //每次循环体内部再进行一次双指针比较
            while (f < l) {
                if (nums[i] + nums[f] + nums[l] > 0) {
                    l--;
                } else if (nums[i] + nums[f] + nums[l] < 0) {
                    f++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[f]);
                    list.add(nums[l]);
                    result.add(list);
                    l--;
                    f++;
                    //这个f<l的条件不加会数组越界
                    while (f < l && nums[f] == nums[f - 1]) {
                        f++;
                    }
                    //这个f<l的条件不加会数组越界
                    while (f < l && nums[l] == nums[l + 1]) {
                        l--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvmy42/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     */
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] zeros = new boolean[m + n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeros[i] = true;
                    zeros[m + j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeros[i] || zeros[m + j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
