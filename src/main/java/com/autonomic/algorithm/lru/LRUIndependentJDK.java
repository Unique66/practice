/*
 * Copyright (c) 2021.  User:SXH  File:LRUIndependentJDK.java
 * Date:2021/04/26 23:30:26
 */

package com.autonomic.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SXH
 * @description 不依赖JDK，实现LRU 算法
 * @date 2021/4/26 23:30
 */
public class LRUIndependentJDK {
    // 哈希+链表实现
    // map 负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个Node 节点，Node 节点作为数据载体
    public static void main(String[] args) {
        LRUIndependentJDK lruCache = new LRUIndependentJDK(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(4, 4);
        System.out.println(lruCache.map.keySet());

        lruCache.put(3, 33);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 333);
        System.out.println(lruCache.map.keySet());
        System.out.println(lruCache.map.get(3).value);
        lruCache.put(5, 5);
        System.out.println(lruCache.map.keySet());
        lruCache.put(6, 6);
        System.out.println(lruCache.map.keySet());
    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUIndependentJDK(int cacheSize) {
        this.cacheSize = cacheSize; // 总坑位
        map = new HashMap<>(); // 查找数据
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        // 判断map 中是否有
        if (!map.containsKey(key)) {
            return -1; // 不存在
        }
        // 如果map 中存在，就将Node 从双向链表中删除，然后放到链表头部
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    // 放入内容，相当于insert or update
    public void put(int key, int value) {
        // update
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else { // insert
            // 判断是否满了
            if (map.size() == cacheSize) {
                // 需要将链表尾部的Node 删除
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            // 加入新的Node
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    // 1.构造一个Node 节点，作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // 2.构造一个双向链表，里面放Node
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        // 2.1 构造方法
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 2.2 添加节点到头部，所以代码里要出现head 与之关联，不能出现tail，可能内部存在多个Node了已经
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 2.3 删除节点
        public void removeNode(Node<K, V> node) {
            // 删除节点代码中不能出现head 和tail，因为可能内部已经有多个Node 节点了，删除中间的与head 和tail 无关
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null; // help GC
            node.next = null;
        }

        // 2.4 获得最后一个节点
        public Node<K, V> getLast() {
            // 如果坑位满了，就要获得最后一个节点，然后调用删除节点的方法，从数据结构中删除，以便放入新的节点
            return tail.prev;
        }
    }
}
