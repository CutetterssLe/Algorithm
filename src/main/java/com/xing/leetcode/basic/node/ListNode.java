package com.xing.leetcode.basic.node;

import java.util.Objects;

/**
 * @author Mystery
 */
public class ListNode {

    public int index;

    public ListNode next;

    public int min;

    public ListNode(int index, ListNode next, int min) {
        this.index = index;
        this.next = next;
        this.min = min;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return index == listNode.index && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, next);
    }
}
