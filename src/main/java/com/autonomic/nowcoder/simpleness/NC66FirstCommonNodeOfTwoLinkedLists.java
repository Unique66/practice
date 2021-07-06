/*
 * Copyright (c) 2021.  User:Unique66 File:NC66FirstCommonNodeOfTwoLinkedLists.java
 * Date:2021/07/06 00:36:06
 */

package com.autonomic.nowcoder.simpleness;

import java.util.HashMap;

/**
 * @author Unique66
 * @description NC66 两个链表的第一个公共结点  考察点：链表
 * @date 2021/7/6 0:36
 * <p>
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&&tqId=37761&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 * <p>
 * 示例1
 * 输入：{1,2,3},{4,5},{6,7}
 * 返回值：{6,7}
 * 说明：
 * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，
 * 最后的{6,7}表示的是2个链表的公共部分
 * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 * <p>
 * 示例2
 * 输入：{1},{2,3},{}
 * 返回值：{}
 * 说明：
 * 2个链表没有公共节点 ,返回null，后台打印{}
 */
public class NC66FirstCommonNodeOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(4);
        ListNode pHead2 = new ListNode(5);
        pHead2.next = new ListNode(6);
        pHead2.next.next = new ListNode(7);

        System.out.println(FindFirstCommonNode1(pHead1, pHead2));
    }

    // 方法1：双指针，不太理解
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    // 方法2：从后向前找，可以利用Stack，先将两个链表放入到两个栈中，然后从两个栈顶开始找，
    // 相同pop，第一次找到栈顶值不同的就是要找的第一个公共节点

    // 比较离谱的一种写法：使用HashMap 暂存
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode result = new ListNode(0);
        if (pHead1 == null || pHead2 == null) {
            return result.next;
        }
        // 将链表1 放到HashMap 数据结构中，方便查找
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp1 = pHead1;
        while (temp1 != null) {
            map.put(temp1.val, temp1);
            temp1 = temp1.next;
        }

        ListNode temp2 = pHead2;
        boolean search = false;
        while (temp2 != null) {
            if (map.containsKey(temp2.val)) { // 第一次找到公共节点
                search = true;
                break;
            }
            temp2 = temp2.next;
        }
        if (search) {
            temp1 = map.get(temp2.val);
            ListNode temp = result;
            while (temp1 != null && temp2 != null && temp1.val == temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return result.next;
    }
}
