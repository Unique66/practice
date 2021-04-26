/*
 * Copyright (c) 2021.  User:SXH  File:LRUExtendLinkedHashMap.java
 * Date:2021/04/26 23:05:26
 */

package com.autonomic.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SXH
 * @description 依赖JDK，继承LinkedHashMap 实现LRU 算法
 * @date 2021/4/26 23:05
 */
public class LRUDependJDK extends LinkedHashMap {
    private int capacity; // 缓存坑位

    /**
     *
     * accessOrder     the ordering mode - <tt>true</tt> for
     * access-order, <tt>false</tt> for insertion-order
     */
    public LRUDependJDK(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 如果当前元素个数大于限制的capacity 配置，就将Eldest 元素剔除
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUDependJDK lruCache = new LRUDependJDK(3); // 配置元素个数上限为3个
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(4, "d");
        System.out.println(lruCache.keySet());

        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(5, "x");
        System.out.println(lruCache.keySet());
        lruCache.put(6, "y");
        System.out.println(lruCache.keySet());
    }

    /*
     * true - 访问顺序
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 4, 3]
     * [2, 4, 3]
     * [2, 4, 3]
     * [4, 3, 5]
     * [3, 5, 6]
     */

    /*
     * false - 插入顺序
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [3, 4, 5]
     * [4, 5, 6]
     */
}
