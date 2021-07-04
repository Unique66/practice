/*
 * Copyright (c) 2021.  User:SXH  File:NC78ReverseLinkedList.java
 * Date:2021/07/04 23:21:04
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author SXH
 * @description NC78 反转链表
 * @date 2021/7/4 23:21
 *
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=117&&tqId=37777&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 示例1
 * 输入：{1,2,3}
 * 返回值：{3,2,1}
 */
public class NC78ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("List needn't reverse.");
            return head;
        }
        // 设置辅助头结点
        ListNode helpNode = new ListNode(0);
        ListNode temp = head;
        ListNode next = null; // 记录下一个待处理的节点
        while (temp != null) {
            next = temp.next;
            temp.next = helpNode.next;
            helpNode.next = temp;
            temp = next;
        }
        // while 循环完毕后，已经将链表翻转
        ListNode reverseNode = helpNode.next;
        helpNode.next = null; // 辅助节点helpGC
        return reverseNode;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
