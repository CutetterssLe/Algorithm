package com.xing.leetcode.basic;

import com.xing.leetcode.basic.node.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Mystery
 */
public class NodeAlgorithm {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        deleteNode(listNode);
        System.out.println(listNode);
    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param listNode
     */
    private static void deleteNode(ListNode listNode) {
        listNode.index = listNode.next.index;
        listNode.next = listNode.next.next;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
     * 来源：力扣（LeetCode）
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int length = length(head);
        int index = length - n;
        //如果last等于0表示删除的是头结点
        if (index == 0) {
            return head.next;
        }
        //这里首先要找到要删除链表的前一个结点
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 链表长度
     * @param node
     * @return
     */
    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode pop = stack.pop();
        ListNode dummy = pop;
        while (!stack.isEmpty()) {
            pop.next = stack.pop();
            pop = pop.next;
        }
        pop.next = null;
        return dummy;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            if (l1.index <= l2.index) {
                    result.next = l1;
                    l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        result.next = l1 == null ? l2 : l1;
        return temp.next;
    }

    /**
     * 请判断一个链表是否为回文链表。
     * 输入: 1->2->2->1
     * 输出: true
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
     * 反转后半部分链表，然后对比
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        ListNode first = head, last = head;
        //通过快慢指针找到中点
        while (first != null && first.next != null) {
            first = first.next.next;
            last = last.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (first != null) {
            last = last.next;
        }
        //反转后半部分链表
        last = reverseList(last);
        first = head;
        while (last != null) {
            if (last.index != first.index) {
                return false;
            }
            first = first.next;
            last = last.next;
        }
        return true;
    }
}
