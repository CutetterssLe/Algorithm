package com.xing.leetcode.basic;

import java.util.Arrays;

/**
 * @author Mystery
 */
public class SortAndSearchAlgorithm {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 7, 9, 0, 0, 0};
        int[] num2 = {2, 6, 8};
//        System.out.println(Arrays.toString(merge(num1, 5, num2, 3)));
        System.out.println(firstBadVersion(1000000000));
    }

    /**
     * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 归并排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[index++] = nums1[i++];
        }
        while (j < n) {
            temp[index++] = nums2[j++];
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
        return nums1;
    }

    /**
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 二分查找
     * @param version
     * @return
     */
    private static int firstBadVersion(int version) {
        int start = 1, end = version;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        if (mid <= 4) {
            return false;
        }
        return true;
    }
}
