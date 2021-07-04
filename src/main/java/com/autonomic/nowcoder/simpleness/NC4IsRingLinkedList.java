/*
 * Copyright (c) 2021.  User:SXH  File:NC4IsRingLinkedList.java
 * Date:2021/07/05 00:37:05
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC4 判断链表中是否有环 考察点：链表
 * @date 2021/7/5 0:37
 * <p>
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=117&&tqId=37714&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度的解法么？
 * 输入分为2部分，第一部分为链表，第二部分代表是否有环，然后回组成head头结点传入到函数里面。-1代表无环，
 * 其他的数字代表有环，这些参数解释仅仅是为了方便读者自测调试
 * <p>
 * 示例1
 * 输入：{3,2,0,-4},1
 * 返回值：true
 * <p>
 * 说明：
 * 第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1，即-4->2存在一个链接，
 * 组成传入的head为一个带环的链表，返回true
 * <p>
 * 示例2
 * 输入：{1},-1
 * 返回值：false
 * <p>
 * 说明：
 * 第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false
 * <p>
 * 示例3
 * 输入：{-1,-7,7,-4,19,6,-9,-5,-2,-5},6
 * 返回值：true
 */
public class NC4IsRingLinkedList {
    public boolean hasCycle(ListNode head) {
        return false;
    }
}
