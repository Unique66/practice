/*
 * Copyright (c) 2022.  User:Unique66 File:LeetCode86.java
 * Date:2022/12/07 22:55:07
 */

package com.autonomic.leetcode.medium;

import com.autonomic.leetcode.util.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        // 存放小于 x 的链表的虚拟头结点
        ListNode less = new ListNode();
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode more = new ListNode();
        // tempLess, tempMore 指针负责生成结果链表
        ListNode tempLess = less;
        ListNode tempMore = more;
        while (head != null) {
            if (head.val < x) {
                // 小的，放到临时小链表中
                tempLess.next = head;
                // 小链表指向下一个，以便下一次加入新的节点
                tempLess = tempLess.next;
            } else {
                tempMore.next = head;
                tempMore = tempMore.next;
            }
            // 将节点从原有的head链表中剪出来，放到或大或小链表中
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        tempLess.next = more.next;
        return less.next;
    }
}
