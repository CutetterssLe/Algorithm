package com.xing.leetcode.剑指offer;

import java.util.LinkedList;

/**
 * @author Mystery
 * 2个栈实现队列
 */
public class CQueue {

    private LinkedList<Integer> l1;
    private LinkedList<Integer> l2;

    public LinkedList<Integer> getS1() {
        return l1;
    }

    public void setS1(LinkedList<Integer> s1) {
        this.l1 = s1;
    }

    public LinkedList<Integer> getS2() {
        return l2;
    }

    public void setS2(LinkedList<Integer> s2) {
        this.l2 = s2;
    }

    public CQueue() {
        l1 = new LinkedList<>();
        l2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        l1.add(value);
    }

    public int deleteHead() {
        if (l2.isEmpty()) {
            if (l1.isEmpty()) {
                return -1;
            }
            while (!l1.isEmpty()) {
                l2.add(l1.pop());
            }
        }
        return l2.pop();
    }

    @Override
    public String toString() {
        return "CQueue{" +
                "l1=" + l1 +
                ", l2=" + l2 +
                '}';
    }
}
