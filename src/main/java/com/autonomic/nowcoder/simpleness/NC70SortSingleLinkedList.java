/*
 * Copyright (c) 2021.  User:Unique66 File:NC70SortSingleLinkedList.java
 * Date:2021/07/06 00:54:06
 */

package com.autonomic.nowcoder.simpleness;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Unique66
 * @description NC70 单链表的排序 考察点：链表、排序
 * @date 2021/7/6 0:54
 *
 * https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=117&&tqId=37817&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一个无序单链表，实现单链表的排序(按升序排序)。
 *
 * 示例1
 * 输入：[1,3,2,4,5]
 * 返回值：{1,2,3,4,5}
 */
public class NC70SortSingleLinkedList {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    // 归并排序方式
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null)
            return head;
        //使用快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left!=null?left:right;
        return res.next;
    }

    // 2、比较取巧的方式
    public ListNode sortInList1 (ListNode head) {
        // write code here

        ListNode temp = head;
        // 依次将链表的节点放入到List 中
        LinkedList<ListNode> list = new LinkedList<>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        // 对list 按照节点val 排序
        list.sort(Comparator.comparingInt(o -> o.val));
        // 对排序完毕的List遍历拼装最后的升序单链表
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).next = null;
                break;
            }
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
}
