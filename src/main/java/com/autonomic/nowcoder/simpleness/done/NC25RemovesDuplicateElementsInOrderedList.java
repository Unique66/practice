/*
 * Copyright (c) 2021.  User:Unique66 File:NC25RemovesDuplicateElementsInOrderedList.java
 * Date:2021/07/09 00:21:09
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description NC25 删除有序链表中重复的元素 考察点：链表
 * @date 2021/7/8 1:12
 *
 * https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=117&&tqId=37730&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
 * 给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.
 *
 * 示例1
 * 输入：{1,1,2}
 * 返回值：{1,2}
 */
public class NC25RemovesDuplicateElementsInOrderedList {
    /**
     * done.
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        // 处理完毕
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                // 遇到相同的，就指向下一个的下一个，然后继续处理当前节点，判断重指向前的下一个的下一个是不是还和当前节点一样
                cur.next = cur.next.next;
            } else {
                // 下一个是不同的，那么就向后处理找
                cur = cur.next;
            }
        }
        return head;
    }
}
