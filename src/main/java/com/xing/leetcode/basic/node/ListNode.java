package com.xing.leetcode.basic.node;

/**
 * @author Mystery
 */
public class ListNode {

    public int index;

    public ListNode next;

    public ListNode(int index) {
        this.index = index;
    }

    public ListNode() {

    }

    public ListNode(int index, ListNode next) {
        this.index = index;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", next=" + next +
                '}';
    }
}
