/*
 * Copyright (c) 2021.  User:SXH  File:NC33MergeOrderedLinkedList.java
 * Date:2021/07/04 23:30:04
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC33 合并有序链表
 * @date 2021/7/4 23:30
 * <p>
 * 描述
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 * <p>
 * 示例1
 * 输入：{1},{2}
 * 返回值：{1,2}
 * <p>
 * 示例2
 * 输入：{2},{1}
 * 返回值：{1,2}
 */
public class NC33MergeOrderedLinkedList {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    // 递归方式处理
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 判断两个链表是否为空
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 非递归方式
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 判断两个链表是否为空
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // write code here
        // 创建临时变量
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        // 创建最终的合并链表
        ListNode orderedNode = null;
        // 第一次orderedNode节点赋值处理
        if (temp1.val < temp2.val) {
            orderedNode = temp1;
            temp1 = temp1.next;
        } else {
            orderedNode = temp2;
            temp2 = temp2.next;
        }
        // 开始将两个链表按照大小合理的拼装最终的orderedNode
        ListNode n = orderedNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                n.next = temp1;
                temp1 = temp1.next;
            } else {
                n.next = temp2;
                temp2 = temp2.next;
            }
            n = n.next;
        }
        // while 循环走完之后，两个链表中的一个还会有节点，直接加到尾部即可
        if (temp1 != null) {
            n.next = temp1;
        }
        if (temp2 != null) {
            n.next = temp2;
        }
        return orderedNode;
    }
}
