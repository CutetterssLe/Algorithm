package com.xing.leetcode.middle;

import java.util.*;


/**
 * @author Mystery
 */
public class StringAndArrayAlgorithm {
    public static void main(String[] args) throws Exception {
//        int[] nums = {-1, -1, 0, -4, -4, 1, -2, 2, 0, -4};
//        int[] nums = {0, 0, 0};
//        System.out.println(threeSum(nums));
//        String[] strarr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
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

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param strArr
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strArr) {
            char[] chars = str.toCharArray();
            //对char数组进行排序
            Arrays.sort(chars);
            //将排序后的字符串作为key存入map
            String key = String.valueOf(chars);
            //不存在就放一个空list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            //如果存在，把当前字符串放入list在放进map中
            List<String> strings = map.get(key);
            strings.add(str);
            map.put(key, strings);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv2kgi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[255];

        int max = 0, j = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            while (seen[c]) {
                seen[s.charAt(j)] = false;
                j++;
            }
            seen[c] = true;

            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
