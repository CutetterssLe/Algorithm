package com.xing.leetcode.basic;

import com.xing.leetcode.basic.node.TreeNode;

import java.util.*;

/**
 * @author Mystery
 */
public class TreeNodeAlgorithm {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = null;
        treeNode.right.right = null;
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(15);
//        System.out.println(maxDepth(treeNode));
//        System.out.println(isValidBST(treeNode));
        int[] arr = {1, 3, 5, 7, 9, 11, 16, 17, 23};
//        System.out.println(levelOrder(treeNode));
        System.out.println(sortedArrayToBST(arr));
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    private static boolean isValidBST(TreeNode root) {
        //区间递归
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
     * @param root
     * @return
     */
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *    返回：
     *    [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * BFS 广度优先搜索
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        // 边界判断
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就循环
        while (!queue.isEmpty()) {
            //BFS打印，size表示每层的节点数
            int size = queue.size();
            //存储每层的节点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //每层节点值存储在结果中
            lists.add(subList);
        }
        return lists;
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

}
