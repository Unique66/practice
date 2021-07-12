/*
 * Copyright (c) 2021.  User:Unique66 File:ListNode.java
 * Date:2021/07/13 01:07:13
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description ListNode
 * @date 2021/7/13 1:07
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public void showList() {
        ListNode cur = this;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}
