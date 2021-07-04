/*
 * Copyright (c) 2021.  User:SXH  File:Interview1.java
 * Date:2021/05/18 22:33:18
 */

package com.autonomic.book.cartoonalgorithm.interview;

/**
 * @author SXH
 * @description 如何判断链表有环
 * @date 2021/5/18 21:52
 */
public class Interview1 {
    public static void main(String[] args) {
        // 追击问题，假定两个点p0 和p1
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(isCycle(node1));
    }

    /**
     * 判断链表是否有环
     *
     * @param head 链表头
     */
    public static boolean isCycle(Node head) {
        Node p0 = head; // 每次走一步
        Node p1 = head; // 每次走两步
        // 如果是个环，那么p0 和p1 总会相遇
        while (p1 != null && p1.next != null) {
            p0 = p0.next;
            p1 = p1.next.next;
            if (p0 == p1) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
