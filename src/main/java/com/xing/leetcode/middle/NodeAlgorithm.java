package com.xing.leetcode.middle;

import com.xing.leetcode.basic.node.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Mystery
 */
public class NodeAlgorithm {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        System.out.println(addTwoNumbers(l1, l2));
        System.out.println(oddEvenList(l1));
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
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

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvdwtj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     *
     * 1、按照顺序的奇偶性重排，奇数在前，偶数在后
     * 2、如果链表长度小于3，则无需重排
     * 3、可使用两个指针，遍历链表，一个连接奇数节点，一个连接偶数节点，最后合并
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        //如果链表长度小于3，则不用重排
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //记录基数链表
        ListNode p = head;
        //记录偶数链表
        ListNode q = head.next;
        //偶数链表首指针
        ListNode tail = q;
        ListNode currentNode = q.next;
        //判断是奇数还是偶数链表
        boolean odd = true;

        while (currentNode != null) {
            if (odd) {
                p.next = currentNode;
                p = currentNode;
            } else {
                q.next = currentNode;
                q = currentNode;
            }
            odd = !odd;
            currentNode = currentNode.next;
        }
        //判断偶数链表末尾是否需要置空
        if (!odd) {
            q.next = null;
        }
        //合并链表
        p.next = tail;
        return head;
    }
}
