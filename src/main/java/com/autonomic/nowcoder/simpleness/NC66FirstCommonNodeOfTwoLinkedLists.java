/*
 * Copyright (c) 2021.  User:Unique66 File:NC66FirstCommonNodeOfTwoLinkedLists.java
 * Date:2021/07/06 00:36:06
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC66 两个链表的第一个公共结点  考察点：链表
 * @date 2021/7/6 0:36
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&&tqId=37761&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 *
 * 示例1
 * 输入：{1,2,3},{4,5},{6,7}
 * 返回值：{6,7}
 * 说明：
 * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，
 * 最后的{6,7}表示的是2个链表的公共部分
 * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 *
 * 示例2
 * 输入：{1},{2,3},{}
 * 返回值：{}
 * 说明：
 * 2个链表没有公共节点 ,返回null，后台打印{}
 */
public class NC66FirstCommonNodeOfTwoLinkedLists {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return null;
    }
}
