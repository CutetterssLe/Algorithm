package com.xing.leetcode.middle;

import com.xing.leetcode.basic.node.ListNode;

/**
 * @author Mystery
 */
public class NodeAlgorithm {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode now = res;
        int carry = 0;
        while (carry > 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.index;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.index;
                l2 = l2.next;
            }

            now.next = new ListNode(carry % 10);
            now = now.next;
            carry /= 10;
        }
        return res.next;
    }
}
