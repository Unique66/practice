/*
 * Copyright (c) 2021.  User:Unique66 File:NC96PalindromeJudgmentOfLinkedList.java
 * Date:2021/07/07 00:20:07
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC96 判断一个链表是否为回文结构 考察点：链表、双指针
 * @date 2021/7/7 0:20
 *
 * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=117&&tqId=37813&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一个链表，请判断该链表是否为回文结构。
 *
 * 示例1
 * 输入：[1]
 * 返回值：true
 *
 * 示例2
 * 输入：[2,1]
 * 返回值：false
 * 说明：2->1
 *
 * 示例3
 * 输入：[1,2,2,1]
 * 返回值：true
 * 说明：1->2->2->1
 *
 * 备注：
 * 1 ≤ n ≤ 10^6
 */
public class NC96PalindromeJudgmentOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next  = new ListNode(2);
        head.next.next .next  = new ListNode(1);
        reverseNode(head).showList();
        System.out.println("----------");
        head.showList();
    }
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 使用双指针概念，快慢指针，找到链表的中间位置
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // 移动距离是slow 的两倍，就会找到链表终点
        }
        // 此时slow 就是链表的中间位置
        fast = slow.next;
        slow.next = null;
        ListNode reverseNode = reverseNode(fast);

        // 翻转后面链表后，对比两个链表的节点
        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    // 工具方法：翻转节点
    public static ListNode reverseNode (ListNode head) {
        // 创建辅助节点
        ListNode helpNode = new ListNode(0);
        ListNode temp = head;
        ListNode next = null;
        while (temp != null) {
            // 先记录下一个节点
            next = temp.next;
            // 处理当前处理节点的指向关系
            temp.next = helpNode.next;
            // 处理辅助节点指向最新的节点，保证翻转
            helpNode.next = temp;
            // 处理下一个节点
            temp = next;
        }
        // 最后处理完毕
        return helpNode.next;
    }
}
